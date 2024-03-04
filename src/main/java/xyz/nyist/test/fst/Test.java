package xyz.nyist.test.fst;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.BytesRef;
import org.apache.lucene.util.IntsRefBuilder;
import org.apache.lucene.util.fst.FST;
import org.apache.lucene.util.fst.FSTCompiler;
import org.apache.lucene.util.fst.PositiveIntOutputs;
import org.apache.lucene.util.fst.Util;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * @author: silence
 * @Date: 2022/5/13 17:11
 * @Description: https://leetcode.cn/problems/one-away-lcci/submissions/
 */
public class Test {


    public static void main(String[] args) throws Exception {
        //testSearch();
        fst();
    }


    // 创建索引  https://blog.csdn.net/z_ssyy/article/details/105234446
    public static void CreateIndex() throws Exception {
        //1 创建文档对象
        Document document = new Document();
        // 创建并添加字段信息。参数：字段的名称、字段的值、是否存储，这里选Store.YES代表存储到文档列表。Store.NO代表不存储
        document.add(new StringField("id", "1", Field.Store.YES));
        // 这里我们title字段需要用TextField，即创建索引又会被分词。StringField会创建索引，但是不会被分词
        document.add(new TextField("title", "谷歌地图之父跳槽facebook", Field.Store.YES));

        //2 索引目录类,指定索引在硬盘中的位置
        Directory directory = FSDirectory.open(Paths.get("lucene/"));
        //3 创建分词器对象
        Analyzer analyzer = new StandardAnalyzer();
        //4 索引写出工具的配置对象
        IndexWriterConfig conf = new IndexWriterConfig(analyzer);
        //5 创建索引的写出工具类。参数：索引的目录和配置信息
        IndexWriter indexWriter = new IndexWriter(directory, conf);

        //6 把文档交给IndexWriter
        indexWriter.addDocument(document);
        //7 提交
        indexWriter.commit();
        //8 关闭
        indexWriter.close();
    }


    public static void testSearch() throws Exception {
        // 索引目录对象
        Directory directory = FSDirectory.open(Paths.get("lucene/"));
        // 索引读取工具
        IndexReader reader = DirectoryReader.open(directory);
        // 索引搜索工具
        IndexSearcher searcher = new IndexSearcher(reader);

        // 创建查询解析器,两个参数：默认要查询的字段的名称，分词器
        //QueryParser parser = new QueryParser("title", new IKAnalyzer());
        // 创建查询对象
        TermQuery termQuery = new TermQuery(new Term("id", "1"));
        FuzzyQuery fuzzyQuery = new FuzzyQuery(new Term("title", "谷歌"));
        //Query query = parser.parse("谷歌");

        // 搜索数据,两个参数：查询条件对象要查询的最大结果条数
        // 返回的结果是 按照匹配度排名得分前N名的文档信息（包含查询到的总条数信息、所有符合条件的文档的编号信息）。
        TopDocs topDocs = searcher.search(termQuery, 10);
        // 获取总条数
        System.out.println("本次搜索共找到" + topDocs.totalHits + "条数据");
        // 获取得分文档对象（ScoreDoc）数组.SocreDoc中包含：文档的编号、文档的得分
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (ScoreDoc scoreDoc : scoreDocs) {
            // 取出文档编号
            int docID = scoreDoc.doc;
            // 根据编号去找文档
            Document doc = reader.document(docID);
            System.out.println("id: " + doc.get("id"));
            System.out.println("title: " + doc.get("title"));
            // 取出文档得分
            System.out.println("得分： " + scoreDoc.score);
        }
    }


    public static void fst() throws IOException {

        String[] inputValues = {"lu", "lucene", "luk", "pat", "push", "start", "tart"};
        long[] outputValues = {101, 90, 80, 66, 83, 57, 56};

        PositiveIntOutputs outputs = PositiveIntOutputs.getSingleton();
        FSTCompiler.Builder<Long> builder = new FSTCompiler.Builder<>(FST.INPUT_TYPE.BYTE1, outputs);
        FSTCompiler<Long> build = builder.build();
        IntsRefBuilder intsRefBuilder = new IntsRefBuilder();
        for (int i = 0; i < inputValues.length; i++) {
            BytesRef bytesRef = new BytesRef(inputValues[i]);
            build.add(Util.toIntsRef(bytesRef, intsRefBuilder), outputValues[i]);
        }

        FST<Long> fst = build.compile();
        BytesRef bytesRef = new BytesRef("luk");
        Long aLong = Util.get(fst, Util.toIntsRef(bytesRef, intsRefBuilder));
        System.out.println(aLong);

    }

}

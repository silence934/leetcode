package xyz.nyist.leetcode.begin800;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author: silence
 * @Date: 2022/11/30 14:44
 * @Description:
 */
public class Solution895 {

    Map<Integer, LinkedList<Integer>> map;

    PriorityQueue<Entity> queue;

    Integer index;

    public Solution895() {
        map = new HashMap<>();
        queue = new PriorityQueue<>(((o1, o2) -> {
            if (o1.size == o2.size) {
                return Integer.compare(o2.index, o1.index);
            } else {
                return Integer.compare(o2.size, o1.size);
            }
        }));
        index = 0;
    }

    public void push(int val) {
        if (map.containsKey(val)) {
            LinkedList<Integer> list = map.get(val);
            if (!list.isEmpty()) {
                queue.remove(new Entity(list.getFirst(), val, list.size()));
            }
            list.addFirst(index);
            queue.offer(new Entity(index++, val, list.size()));
        } else {
            LinkedList<Integer> list = new LinkedList<>();
            list.addFirst(index);
            queue.offer(new Entity(index++, val, list.size()));
            map.put(val, list);
        }
    }

    public int pop() {
        Entity poll = queue.poll();
        LinkedList<Integer> list = map.get(poll.key);
        list.removeFirst();
        if (!list.isEmpty()) {
            queue.offer(new Entity(list.getFirst(), poll.key, list.size()));
        }
        return poll.key;
    }


    private static class Entity {
        int index;
        int key;
        int size;

        public Entity(int index, int key, int size) {
            this.index = index;
            this.key = key;
            this.size = size;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Entity entity = (Entity) o;

            if (index != entity.index) return false;
            if (key != entity.key) return false;
            return size == entity.size;
        }

        @Override
        public int hashCode() {
            int result = index;
            result = 31 * result + key;
            result = 31 * result + size;
            return result;
        }

        @Override
        public String toString() {
            return "Entity{" +
                    "index=" + index +
                    ", key=" + key +
                    ", size=" + size +
                    '}';
        }
    }
}

import java.awt.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


/*
*  5
*  4
*  3   6
*  2 U U
* */
//public class RobotCleanRoom extends CleanRobot {
//    Stack<String> path;
//    Stack<Plan> plans;
//    Node cur;
//
//    public RobotCleanRoom() {
//        path = new Stack<>();
//        plans = new Stack<>();
//        cur = new Node(0, 0);
//    }
//
//    public void cleanRoom() {
//        Set<Node> visited = new HashSet<>();
//        visited.add(cur);
//        Clean();
//
//        plans.push(new Plan("Up", cur));
//        plans.push(new Plan("Down", cur));
//        plans.push(new Plan("Left", cur));
//        plans.push(new Plan("Right", cur));
//
//        while (!plans.isEmpty()) {
//            Plan plan = plans.pop();
//
//            while (!cur.equals(plan.node)) {
//                Return();
//            }
//
//            Node next;
//            switch (plan.dir) {
//                case "Up" :
//                    next = new Node(cur.x, cur.y + 1);
//                    if (!visited.contains(next) && MoveUP()) {
//                        path.push("Up");
//                    }
//                    break;
//                case "Down" :
//                    next = new Node(cur.x, cur.y - 1);
//                    if (!visited.contains(next) && MoveDown()) {
//                        path.push("Down");
//                    }
//                    break;
//                case "Left" :
//                    next = new Node(cur.x - 1, cur.y);
//                    if (!visited.contains(next) && MoveLeft()) {
//                        path.push("Left");
//                    }
//                    break;
//                case "Right" :
//                    next = new Node(cur.x + 1, cur.y);
//                    if (!visited.contains(next) && MoveRight()) {
//                        path.push("Right");
//                    }
//                    break;
//            }
//
//            if (!visited.contains(cur)) {
//                Clean();
//                visited.add(cur);
//                plans.push(new Plan("Up", cur));
//                plans.push(new Plan("Down", cur));
//                plans.push(new Plan("Left", cur));
//                plans.push(new Plan("Right", cur));
//            }
//        }
//    }
//
//    private boolean MoveUP(){
//        if (Move()) {
//            cur = new Node(cur.x, cur.y + 1);
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    private boolean MoveDown(){
//        TurnLeft(2);
//        if (Move()) {
//            TurnLeft(2);
//            cur = new Node(cur.x, cur.y - 1);
//            return true;
//        } else {
//            TurnLeft(2);
//            return false;
//        }
//    }
//
//    private boolean MoveLeft(){
//        TurnLeft(1);
//        if (Move()) {
//            TurnRight(1);
//            cur = new Node(cur.x - 1, cur.y);
//            return true;
//        } else {
//            TurnRight(1);
//            return false;
//        }
//    }
//
//    private boolean MoveRight(){
//        TurnRight(1);
//        if (Move()) {
//            TurnLeft(1);
//            cur = new Node(cur.x + 1, cur.y);
//            return true;
//        } else {
//            TurnLeft(1);
//            return false;
//        }
//    }
//
//    void Return(){
//        String str = path.pop();
//        switch (str) {
//            case "Up" : MoveDown();
//                break;
//            case "Down" : MoveUP();
//                break;
//            case "Left" : MoveRight();
//                break;
//            case "Right" : MoveLeft();
//                break;
//        }
//    }
//
//    private class Plan {
//        String dir;
//        Node node;
//
//        public Plan(String dir, Node node) {
//            this.dir = dir;
//            this.node = node;
//        }
//    }
//
//    private class Node {
//        int x;
//        int y;
//
//        public Node(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//
//        @Override
//        public boolean equals(Object that) {
//            return that != null && that instanceof Node
//                    && ((Node)that).x == this.x
//                    && ((Node)that).y == this.y;
//        }
//
//        @Override
//        public int hashCode() {
//            return (31 * x) + y;
//        }
//    }
//}
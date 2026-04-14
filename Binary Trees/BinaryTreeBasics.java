import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeBasics {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    static class BinaryTree{
        static int idx=-1;
        public static Node buildTree(int[] nodes){    // from preorder
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode=new Node(nodes[idx]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);

            return newNode;
        }

        public static int height(Node root){
            if(root==null)return 0;

            int left=height(root.left);
            int right=height(root.right);

            return 1+Math.max(left,right);
        }

        public static int countOfNodes(Node root){
            if(root==null)return 0;

            int left=countOfNodes(root.left);
            int right=countOfNodes(root.right);

            return left+right+1;
        }

        public int sumOfNodes(Node root){
            if(root==null)return 0;

            int leftSum=sumOfNodes(root.left);
            int rightSum=sumOfNodes(root.right);

            return leftSum+rightSum+root.data;
        }

        public int diameter1(Node root){  //O(n^2)
            if(root==null)return 0;

            int leftDiam=diameter1(root.left);
            int leftHt=height(root.left);

            int rightDiam=diameter1(root.right);
            int rightHt=height(root.right);

            int selfDiam=leftHt+rightHt+1;

            return Math.max(leftDiam,Math.max(rightDiam,selfDiam));
        }

        static class Info{
            int diam;
            int ht;
            Info(int diam,int ht){
                this.diam=diam;
                this.ht=ht;
            }
        }
        public Info diameter2(Node root){  //O(n)
            if(root==null){
                return new Info(0, 0);
            }

            Info leftInfo=diameter2(root.left);
            Info rightInfo=diameter2(root.right);

            int diam=Math.max(leftInfo.diam,Math.max(rightInfo.diam,leftInfo.ht+rightInfo.ht+1));
            int ht=Math.max(leftInfo.ht,rightInfo.ht)+1;

            return new Info(diam, ht);


        }

        static class InfoNode{
            Node node;
            int hd;
            InfoNode(Node node,int hd){
                this.node=node;
                this.hd=hd;
            }
        }

        public static void topView(Node root){
            //level order
            Queue<InfoNode>q=new LinkedList<>();
            HashMap<Integer,Node>map=new HashMap<>();

            int min=0,max=0;

            q.add(new InfoNode(root, 0));
            q.add(null);

            while(!q.isEmpty()){
                InfoNode curr=q.poll();
                if(curr==null){
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }


                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd, curr.node);
                }

                if(curr.node.left!=null){
                    q.add(new InfoNode(curr.node.left, curr.hd-1));
                    min=Math.min(min,curr.hd-1);
                }
                if(curr.node.right!=null){
                    q.add(new InfoNode(curr.node.right, curr.hd+1));
                    max=Math.max(max,curr.hd+1);
                }


                for(int i=min;i<=max;i++){
                    System.out.println(map.get(i).data+" ");
                }

            }


        }

        static void Klevel(Node root,int level,int K){
            if(root==null){
                return;
            }
            if(level==K){
                System.out.print(root.data+" ");
                return;
            }

            Klevel(root.left, level+1, K);
            Klevel(root.right, level+1, K);
        }


        static boolean getPath(Node root,int n,ArrayList<Node>path){
            if(root==null){
                return false;
            }
            path.add(root);

            if(root.data==n){
                return true;
            }
            boolean foundLeft=getPath(root.left, n, path);
            boolean foundRight=getPath(root.right, n, path);


            if(foundLeft || foundRight){
                return true;
            }
            path.remove(path.size()-1);
            return false;
        }

        static Node lca(Node root,int n1,int n2){
            ArrayList<Node>path1=new ArrayList<>();
            ArrayList<Node>path2=new ArrayList<>();

            getPath(root,n1,path1);
            getPath(root,n2,path2);

            int i=0;
            for(;i<path1.size() &&  i< path2.size();i++){
                if(path1.get(i)!=path2.get(i)){
                    break;
                }
            }

            Node lca=path1.get(i-1);
            return lca;
        }


        static Node lca2(Node root,int n1,int n2){
            if(root==null || root.data==n1 || root.data==n2){
                return root;
            }

            Node leftLca=lca2(root.left, n1, n2);
            Node rightLca=lca2(root.right, n1, n2);

            if(rightLca==null){
                return leftLca;
            }
            if(leftLca==null){
                return rightLca;
            }

            return root;
        }

        static int lcaDist(Node root,int n){
            if(root==null){
                return -1;
            }
            if(root.data==n){
                return 0;
            }

            int leftDistance=lcaDist(root.left, n);
            int rightDistance=lcaDist(root.right, n);

            if(leftDistance==-1 && rightDistance==-1){
                return -1;
            }
            else if(leftDistance==-1){
                return rightDistance+1;
            }
            else{
                return leftDistance+1;
            }
        }
        static int minDistanceBetweenNodes(Node root,int n1,int n2){
            Node lca=lca2(root, n1, n2);
            int dist1=lcaDist(lca,n1);
            int dist2=lcaDist(lca,n2);
            return dist1+dist2;
        }

        static int KAncestor(Node root,int n,int k){
            if(root==null){
                return -1;
            }
            if(root.data==n){
                return 0;
            }

            int leftDist=KAncestor(root.left, n, k);
            int rightDist=KAncestor(root.right, n, k);

            if(leftDist==-1 && rightDist==-1){
                return -1;
            }
            int max=Math.max(leftDist,rightDist);
            if(max+1==k){
                System.out.println(root.data);
            }
            return  max+1;
        }

        static int transform(Node root){
            if(root==null){
                return 0;
            }
            int leftSum=transform(root.left);
            int rightSum=transform(root.right);

            int old=root.data;
            root.data=leftSum+rightSum;
            return old+root.data;
        }
    
    }
    public static void main(String[] args) {
        
    }
    
}

import java.util.*;

class AhoCorasick {
    static class Node {
        Node[] children;
        int index; // Índice da palavra-chave, se for um nó folha
        Node fail;

        Node() {
            children = new Node[26]; // Assumindo alfabeto de 26 letras
            index = -1;
            fail = null;
        }
    }

    static Node root;

    // Insere uma palavra-chave no Trie
    static void insert(String word, int index) {
        Node current = root;
        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            if (current.children[i] == null) {
                current.children[i] = new Node();
            }
            current = current.children[i];
        }
        current.index = index;
    }

    // Calcula a função de falha
    static void computeFailureFunction() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 26; i++) {
                Node n = node.children[i];
                if (n != null) {
                    if (node == root) {
                        n.fail = root;
                    } else {
                        Node t = node.fail;
                        while (t != null && t.children[i] == null) {
                            t = t.fail;
                        }
                        n.fail = (t == null) ? root : t.children[i];
                    }
                    q.add(n);
                }
            }
        }
    }

    // Busca as ocorrências no texto
    static void search(String text) {
        Node current = root;
        for (int i = 0; i < text.length(); i++) {
            int index = text.charAt(i) - 'a';
            while (current != root && current.children[index] == null) {
                current = current.fail;
            }
            current = current.children[index];
            if (current == null) {
                current = root;
            } else {
                Node t = current;
                while (t != null) {
                    if (t.index != -1) {
                        // Encontrou uma ocorrência da palavra-chave com índice t.index
                        System.out.println("Palavra encontrada: " + t.index + " na posição " + (i - t.index));
                    }
                    t = t.fail;
                }
            }
        }
    }

    public static void main(String[] args) {
        root = new Node();
        insert("he", 0);
        insert("she", 1);
        insert("hers", 2);
        computeFailureFunction();
        search("ahshehehis");
    }
}
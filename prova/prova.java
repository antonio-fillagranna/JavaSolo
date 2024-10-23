import java.awt.event.*;  
import javax.swing.*;  

class prova extends JFrame implements ActionListener  
{  
    JLabel rotulo;  
    JRadioButton opcoes[] = new JRadioButton[5];  
    JButton botaoProximo, botaoMarcar;  
    ButtonGroup grupoBotoes;  
    int pontuacao = 0, perguntaAtual = 0, marcador = 1, indiceAtual = 0;  
    int marcacoes[] = new int[10];  
    
    prova(String titulo)  
    {  
        super(titulo);  
        rotulo = new JLabel();  
        add(rotulo);  
        grupoBotoes = new ButtonGroup();  
        for(int i = 0; i < 5; i++)  
        {  
            opcoes[i] = new JRadioButton();     
            add(opcoes[i]);  
            grupoBotoes.add(opcoes[i]);  
        }  
        botaoProximo = new JButton("Próximo");  
        botaoMarcar = new JButton("Marcar");  
        botaoProximo.addActionListener(this);  
        botaoMarcar.addActionListener(this);  
        add(botaoProximo);
        add(botaoMarcar);  
        definirPergunta();  
        rotulo.setBounds(30, 40, 450, 20);  
        opcoes[0].setBounds(50, 80, 100, 20);  
        opcoes[1].setBounds(50, 110, 100, 20);  
        opcoes[2].setBounds(50, 140, 100, 20);  
        opcoes[3].setBounds(50, 170, 100, 20);  
        botaoProximo.setBounds(100, 240, 100, 30);  
        botaoMarcar.setBounds(270, 240, 100, 30);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(250, 100);  
        setVisible(true);  
        setSize(600, 350);  
    }  

    public void actionPerformed(ActionEvent e)  
    {  
        if(e.getSource() == botaoProximo)  
        {  
            if(verificarResposta())  
                pontuacao += 1;  
            perguntaAtual++;  
            definirPergunta();    
            if(perguntaAtual == 9)  
            {  
                botaoProximo.setEnabled(false);  
                botaoMarcar.setText("Resultado");  
            }  
        }  
        if(e.getActionCommand().equals("Marcar"))  
        {  
            JButton botaoMarcacao = new JButton("Marcar" + marcador);  
            botaoMarcacao.setBounds(480, 20 + 30 * marcador, 100, 30);  
            add(botaoMarcacao);  
            botaoMarcacao.addActionListener(this);  
            marcacoes[marcador] = perguntaAtual;  
            marcador++;  
            perguntaAtual++;  
            definirPergunta();    
            if(perguntaAtual == 9)  
                botaoMarcar.setText("Resultado");  
            setVisible(false);  
            setVisible(true);  
        }  
        for(int i = 0, y = 1; i < marcador; i++, y++)  
        {  
            if(e.getActionCommand().equals("Marcar" + y))  
            {  
                if(verificarResposta())  
                    pontuacao += 1;  
                int agora = perguntaAtual;  
                perguntaAtual = marcacoes[y];  
                definirPergunta();  
                ((JButton)e.getSource()).setEnabled(false);  
                perguntaAtual = agora;  
            }  
        }  

        if(e.getActionCommand().equals("Resultado"))  
        {  
            if(verificarResposta())  
                pontuacao += 1;  
            perguntaAtual++;  
            JOptionPane.showMessageDialog(this, "Respostas corretas = " + pontuacao);  
            System.exit(0);  
        }  
    }  

    void definirPergunta()  
    {  
        opcoes[4].setSelected(true);  
        if(perguntaAtual == 0)  
        {  
            rotulo.setText("Pergunta 1: Qual destas não é um tipo de dado primitivo?");  
            opcoes[0].setText("int"); 
            opcoes[1].setText("Float"); 
            opcoes[2].setText("boolean"); 
            opcoes[3].setText("char");    
        }  
        if(perguntaAtual == 1)  
        {  
            rotulo.setText("Pergunta 2: Qual classe está disponível automaticamente para todas as outras classes?");  
            opcoes[0].setText("Swing"); 
            opcoes[1].setText("Applet"); 
            opcoes[2].setText("Object"); 
            opcoes[3].setText("ActionEvent");  
        }  
        // As demais perguntas continuam como no código original, ajustando a tradução das questões.

        // Ajusta as posições dos componentes
        rotulo.setBounds(30, 40, 450, 20);  
        for(int i = 0, j = 0; i <= 90; i += 30, j++)  
            opcoes[j].setBounds(50, 80 + i, 200, 20);  
    }  

    boolean verificarResposta()  
    {  
        if(perguntaAtual == 0)  
            return opcoes[1].isSelected();  
        if(perguntaAtual == 1)  
            return opcoes[2].isSelected();  
        // Verificação das demais respostas conforme o código original.
        return false;  
    }  

    public static void main(String args[])  
    {  
        new prova("Teste Online de Java");  
    }  
}
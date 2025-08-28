import javax.swing.JOptionPane;
public class Exercicios {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Aprendendo Algoritmos", "Algoritmo 11",
                                JOptionPane.INFORMATION_MESSAGE);

                JOptionPane.showMessageDialog(null, "Aprendendo Algoritmos!!!" +
                                "Com Anitta e Guto", "Algoritmo 12",
                                JOptionPane.INFORMATION_MESSAGE);

                int x1 = 10;

                JOptionPane.showMessageDialog(null, x1, "Algoritmo 16",
                                JOptionPane.INFORMATION_MESSAGE);

                JOptionPane.showMessageDialog(null, x1 + 1, "Algoritmo 18",
                                JOptionPane.INFORMATION_MESSAGE);

                String converter = JOptionPane.showInputDialog("Entre com o numero de tres digitos");

                int algarismo = Integer.parseInt(converter), dezena;

                dezena = (algarismo % 100) / 10;

                JOptionPane.showMessageDialog(null, dezena, "Algoritmo 23",
                                JOptionPane.INFORMATION_MESSAGE);


                String converter1 = JOptionPane.showInputDialog("Digite a data no formato DD/MM/AA:");
                int dia = 0, mes = 0, ano = 0;
                boolean dataValida = false;
                if (converter1 != null && converter1.contains("/")) {
                    String[] partes = converter1.split("/");
                    if (partes.length == 3) {
                        try {
                            dia = Integer.parseInt(partes[0]);
                            mes = Integer.parseInt(partes[1]);
                            ano = Integer.parseInt(partes[2]);
                            dataValida = true;
                        } catch (NumberFormatException e) {
                            dataValida = false;
                        }
                    }
                }
                String mensagem;
                if (dataValida) {
                    mensagem = "O dia eh: " + dia + "\n" + "O mes eh: " + mes + "\n" + "E o ano eh: " + ano;
                } else {
                    mensagem = "Data invalida!";
                }
                JOptionPane.showMessageDialog(null, mensagem, "Algoritmo 25", JOptionPane.INFORMATION_MESSAGE);


                String converter2 = JOptionPane.showInputDialog("Digite a data no formato DD/MM/AA:");
                int dia1 = 0, mes1 = 0, ano1 = 0;
                boolean dataValida1 = false;
                if (converter2 != null && converter2.contains("/")) {
                    String[] partes1 = converter2.split("/");
                    if (partes1.length == 3) {
                        try {
                            dia1 = Integer.parseInt(partes1[0]);
                            mes1 = Integer.parseInt(partes1[1]);
                            ano1 = Integer.parseInt(partes1[2]);
                            dataValida1 = true;
                        } catch (NumberFormatException e) {
                            dataValida1 = false;
                        }
                    }
                }
                String mensagem1;
                if (dataValida1) {
                    mensagem1 = "O mes eh: " + mes1 + "\n" + "O dia eh: " + dia1 + "\n" + "E o ano eh: " + ano1;
                } else {
                    mensagem1 = "Data invalida!";
                }
                JOptionPane.showMessageDialog(null, mensagem1, "Algoritmo 26", JOptionPane.INFORMATION_MESSAGE);

                int x = 2, y = 5;

                JOptionPane.showMessageDialog(null, "x = " + x + "\n" + "y = " + y,
                                "Algoritmo 27",
                                JOptionPane.INFORMATION_MESSAGE);

                x++;
                y++;

                JOptionPane.showMessageDialog(null, "O novo valor de x = " + x + "\n" +
                                "O novo valor de y = " + y,
                                "Algoritmo 27", JOptionPane.INFORMATION_MESSAGE);

                int media = (8 + 9 + 7) / 3;

                JOptionPane.showMessageDialog(null,
                                "A media aritmetica dos numeros 8, 9 e 7 eh: " + "\n\n" + media,
                                "Algoritmo 31", JOptionPane.INFORMATION_MESSAGE);

                int dividendo, divisor, quociente, resto;

                String converter3 = JOptionPane.showInputDialog("Entre com o Dividendo!");
                dividendo = Integer.parseInt(converter3);

                converter3 = JOptionPane.showInputDialog("Entre com o Divisor!");
                divisor = Integer.parseInt(converter3);

                quociente = dividendo / divisor;
                resto = dividendo % divisor;

                JOptionPane.showMessageDialog(null,
                                "O valor do divisor eh: " + divisor + "\n" + "O valor do dividendo eh: " +
                                                dividendo
                                                + "\n"
                                                + "O valor do quociente eh: " + quociente + "\n"
                                                + "O valor do resto eh: " + resto,
                                "Algoritmo 40", JOptionPane.INFORMATION_MESSAGE);

                int a, b, c, d, mp;

                String converter4 = JOptionPane.showInputDialog("Digite o numero 1:");
                a = Integer.parseInt(converter4);

                converter4 = JOptionPane.showInputDialog("Digite o numero 2:");
                b = Integer.parseInt(converter4);

                converter4 = JOptionPane.showInputDialog("Digite o numero 3:");
                c = Integer.parseInt(converter4);

                converter4 = JOptionPane.showInputDialog("Digite o numero 4:");
                d = Integer.parseInt(converter4);

                mp = (a * 1 + b * 2 + c * 3 + d * 4) / 10;

                JOptionPane.showMessageDialog(null, "O valor da media ponderada eh: " + mp,
                                "Algoritmo 41",
                                JOptionPane.INFORMATION_MESSAGE);

                Double ang, rang;

                String converter5 = JOptionPane.showInputDialog(null,
                                "Digite o valor do Angulo", "Algoritmo 42",
                                JOptionPane.INFORMATION_MESSAGE);
                ang = Double.parseDouble(converter5);

                rang = (ang * Math.PI) / 180;

                JOptionPane.showMessageDialog(null,
                                "Seno: " + Math.sin(rang) + "\n" + "Coseno: " + Math.cos(rang) + "\n" +
                                                "Tangente: "
                                                + Math.tan(rang)
                                                + "\n" + "Co-secante: " + 1 / Math.sin(rang) + "\n" + "Secante: "
                                                + 1 / Math.cos(rang) + "\n"
                                                + "Cotangente: " + 1 / Math.tan(rang),
                                "Algoritmo 42", JOptionPane.INFORMATION_MESSAGE);

                Double num, log;

                String converter6 = JOptionPane.showInputDialog("Digite o numero para o logaritmo!");
                num = Double.parseDouble(converter6);
                log = Math.log(num) / Math.log(10);

                JOptionPane.showMessageDialog(null, "O Logaritmo eh:" + log, "Algoritmo 43",
                                JOptionPane.INFORMATION_MESSAGE);

                Double num1, log1, base;

                String converter7 = JOptionPane.showInputDialog("Digite o valor do numero para o logaritmo!");
                num1 = Double.parseDouble(converter7);

                converter7 = JOptionPane.showInputDialog("Digite o valor do numero para o logaritmo!");
                base = Double.parseDouble(converter7);

                log1 = Math.log(num1) / Math.log(base);
                JOptionPane.showMessageDialog(null,
                                "O logaritmo de " + num1 + "dividido pelo logaritmo de " + base +
                                                "eh igual a: " + log1,
                                "Algoritmo 44", JOptionPane.INFORMATION_MESSAGE);

                String converter8 = JOptionPane.showInputDialog(null, "Insira o saldo",
                                "Algoritmo 46",
                                JOptionPane.INFORMATION_MESSAGE);

                Double investimento = Double.parseDouble(converter8);
                investimento = investimento * 1.01;

                JOptionPane.showMessageDialog(null, "O saldo apos o investimento eh: " +
                                investimento, "Algoritmo 46",
                                JOptionPane.INFORMATION_MESSAGE);
                String converter9 = JOptionPane.showInputDialog(null, "Insira o salario Minimo: ", "Algoritmo 48",
                                JOptionPane.INFORMATION_MESSAGE);
                Double salarioMin = Double.parseDouble(converter9), precoQuilowatt = ((salarioMin / 7) / 100) * 100;

                String converter10 = JOptionPane.showInputDialog(null,
                                "Insira os quilowatts gastos no mes: " + "Algoritmo 48",
                                JOptionPane.INFORMATION_MESSAGE);
                Double quilowattGasto = Double.parseDouble(converter10), valorTotalPg, valorTotalDesc;

                valorTotalPg = (precoQuilowatt * quilowattGasto);
                precoQuilowatt = Math.round(precoQuilowatt) / 100.0;
                valorTotalPg = Math.round(valorTotalPg) / 100.0;
                valorTotalDesc = valorTotalPg * 0.9;

                JOptionPane.showMessageDialog(null,
                                "O valor pago por quilowatt eh: R$ " + precoQuilowatt + "\n"
                                                + "O valor total a ser pago eh: R$ " + valorTotalPg + "\n"
                                                + "O valor a ser pago com desconto eh: R$ " + valorTotalDesc,
                                "Algoritmo 48", JOptionPane.INFORMATION_MESSAGE);
        }

    }

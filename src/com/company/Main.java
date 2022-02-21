package com.company;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;





public class Main {

    public static void main(String[] args) {









                Scanner ler = new Scanner(System.in);
                Scanner LerTexto = new Scanner(System.in);
                Scanner LerValor = new Scanner(System.in);
                Scanner LerInteiro = new Scanner(System.in);
                int op = 0;

                List<Produto> listaProdutos = new ArrayList<Produto>();
                Produto product;
                do{
                    Menu();
                    op = ler.nextInt();
                    switch(op){
                        case 1:
                            do{
                                menuCadastroProduto();
                                op = ler.nextInt();
                                Cabecalho();
                                switch(op){
                                    case 1:
                                        int aux;
                                        String resp = "";
                                        do{
                                            product = new Produto();


                                            System.out.println("INCLUSÃO DE PRODUTO");
                                            do{
                                                System.out.print("NOME: ");
                                                product.setName(LerTexto.nextLine());
                                                aux = verificarNomeProduto(listaProdutos, product.getName());
                                                if(aux == 1){
                                                    System.out.println("Produto com esse nome já Cadastrado");
                                                }
                                            }while(aux != 0 );

                                            do{
                                                System.out.print("PREÇO: ");
                                                product.setPriceUnit(LerValor.nextDouble());
                                                if(product.getPriceUnit() <= 0){
                                                    System.out.println("Valor Invalido, informe valor maior que zero");
                                                }
                                            }while(product.getPriceUnit() <= 0);
                                            System.out.print("UNIDADE: ");
                                            product.setUnit(LerTexto.nextLine());
                                            do{
                                                System.out.print("QUANTIDADE: ");
                                                product.setQtdEstoque(LerInteiro.nextInt());
                                                if(product.getQtdEstoque() < 0){
                                                    System.out.println("Valor Invalido, informe valor maior ou igual a zero");
                                                }
                                            }while(product.getQtdEstoque() < 0);

                                            System.out.println("CONFIRMA INCLUSÃO (S/N)?");
                                            resp = LerTexto.nextLine();
                                            if(resp.equals("S") || resp.equals("s")){
                                                System.out.println("CADASTRO CONFIRMADO");
                                                listaProdutos.add(product);
                                            }else{
                                                System.out.println("CADASTRO NÃO CONFIRMADO");
                                            }
                                            System.out.println("REPETIR OPERAÇÃO (S/N)?");
                                            resp = LerTexto.nextLine();
                                            if(resp.equals("S") || resp.equals("s")){
                                                aux = 1;
                                            }else{
                                                aux = 0;
                                            }
                                        }while(aux != 0);


                                        break;
                                    case 2:
                                        System.out.println("ALTERAÇÃO DE PRODUTO");
                                        aux = 0;
                                        do{
                                            product = new Produto();
                                            System.out.print("INFORME O NOME DO PRODUTO PARA ALTERAR: ");
                                            product.setName(LerTexto.nextLine());
                                            aux = verificarNomeProduto(listaProdutos, product.getName());
                                            if(aux == 1){
                                                int codProduto = 0;
                                                System.out.println("Produto Existente");
                                                codProduto = exibirPorPorduto(listaProdutos, product.getName());

                                                do{
                                                    System.out.print("INFORME O NOVO PREÇO: ");
                                                    product.setPriceUnit(LerValor.nextDouble());
                                                    if(product.getPriceUnit() <= 0){
                                                        System.out.println("Valor Invalido, informe valor maior que zero");
                                                    }
                                                }while(product.getPriceUnit() <= 0);
                                                System.out.print("INFORME A NOVA UNIDADE: ");
                                                product.setUnit(LerTexto.nextLine());
                                                do{
                                                    System.out.print("INFORME A NOVA QUANTIDADE: ");
                                                    product.setQtdEstoque(LerInteiro.nextInt());
                                                    if(product.getQtdEstoque() < 0){
                                                        System.out.println("Valor Invalido, informe valor maior ou igual a zero");
                                                    }
                                                }while(product.getQtdEstoque() < 0);
                                                System.out.println("CONFIRMA INCLUSÃO (S/N)?");
                                                resp = LerTexto.nextLine();
                                                if(resp.equals("S") || resp.equals("s")){
                                                    System.out.println("ALTERAÇÃO CONFIRMADO");
                                                    listaProdutos.set(codProduto ,product);
                                                }else{
                                                    System.out.println("ALTERAÇÃO NÃO CONFIRMADO");
                                                }


                                            }else{
                                                System.out.println("Produto não Existente");
                                            }
                                            System.out.println("REPETIR OPERAÇÃO (S/N)?");
                                            resp = LerTexto.nextLine();
                                            if(resp.equals("S") || resp.equals("s")){
                                                aux = 1;
                                            }else{
                                                aux = 0;
                                            }

                                        }while(aux != 0);
                                        break;
                                    case 3:
                                        System.out.println("CONSULTA DE PRODUTO");
                                        product = new Produto();
                                        System.out.print("INFORME O NOME DO PRODUTO PARA CONSULTA: ");
                                        product.setName(LerTexto.nextLine());
                                        aux = verificarNomeProduto(listaProdutos, product.getName());
                                        if(aux == 1){
                                            consultaPorPorduto(listaProdutos, product.getName());
                                        }else{
                                            System.out.println("Produto não Existente");
                                        }
                                        break;
                                    case 4:
                                        System.out.println("EXCLUSÃO DE PRODUTO");
                                        product = new Produto();
                                        System.out.print("INFORME O NOME DO PRODUTO PARA EXCLUSÃO: ");
                                        product.setName(LerTexto.nextLine());
                                        aux = verificarNomeProduto(listaProdutos, product.getName());
                                        if(aux == 1){
                                            int codProduto = 0;
                                            System.out.println("Produto Existente");
                                            codProduto = exibirPorPorduto(listaProdutos, product.getName());
                                            System.out.println("CONFIRMA EXCLUSÃO (S/N)?");
                                            resp = LerTexto.nextLine();
                                            if(resp.equals("S") || resp.equals("s")){
                                                System.out.println("EXCLUSÃO CONFIRMADO");
                                                listaProdutos.remove(codProduto);
                                            }else{
                                                System.out.println("EXCLUSÃO NÃO CONFIRMADO");
                                            }
                                        }else{
                                            System.out.println("PRODUTO NÃO CADASTRADO");
                                        }
                                        break;
                                    case 0:
                                        System.out.println("Retorno para Menu Principal");
                                        break;

                                    default:
                                        System.out.println("\nOpção Inválida");
                                        break;

                                }

                            }while(op != 0);

                            op = 1;
                            break;
                        case 2:
                            int aux;
                            String resp = "";
                            do{
                                product = new Produto();
                                menuMovimentacaoProduto();
                                op = ler.nextInt();
                                Cabecalho();
                                switch(op){
                                    case 1:

                                        System.out.println("ENTRADA DE PRODUTO");
                                        product = new Produto();
                                        System.out.print("INFORME O NOME DO PRODUTO: ");
                                        product.setName(LerTexto.nextLine());
                                        aux = verificarNomeProduto(listaProdutos, product.getName());
                                        if(aux == 1){
                                            int codProduto = 0;
                                            System.out.println("Produto Existente");
                                            codProduto = exibirPorPorduto(listaProdutos, product.getName());

                                            do{
                                                System.out.print("QUANTIDADE DE ENTRADA: ");
                                                product.setQtdEstoque(LerInteiro.nextInt());
                                                if(product.getQtdEstoque() < 0){
                                                    System.out.println("Valor Invalido, informe valor maior ou igual a zero");
                                                }
                                            }while(product.getQtdEstoque() < 0);
                                            product.setQtdEstoque(product.getQtdEstoque() + listaProdutos.get(codProduto).getQtdEstoque());
                                            product.setPriceUnit(listaProdutos.get(codProduto).getPriceUnit());
                                            product.setUnit(listaProdutos.get(codProduto).getUnit());

                                            System.out.println("CONFIRMA ENTRADA (S/N)?");
                                            resp = LerTexto.nextLine();
                                            if(resp.equals("S") || resp.equals("s")){
                                                System.out.println("ENTRADA CONFIRMADO");
                                                listaProdutos.set(codProduto, product);
                                            }else{
                                                System.out.println("ENTRADA NÃO CONFIRMADO");
                                            }
                                        }else{
                                            System.out.println("PRODUTO NÃO CADASTRADO");
                                        }

                                        break;
                                    case 2:
                                        System.out.println("SAÍDA DE PRODUTO");
                                        product = new Produto();
                                        System.out.print("INFORME O NOME DO PRODUTO: ");
                                        product.setName(LerTexto.nextLine());
                                        aux = verificarNomeProduto(listaProdutos, product.getName());
                                        if(aux == 1){
                                            int codProduto = 0;
                                            System.out.println("Produto Existente");
                                            codProduto = exibirPorPorduto(listaProdutos, product.getName());
                                            do{
                                                System.out.print("QUANTIDADE DE SAÍDA: ");
                                                product.setQtdEstoque(LerInteiro.nextInt());
                                                if(product.getQtdEstoque() <= 0 || product.getQtdEstoque() > listaProdutos.get(codProduto).getQtdEstoque()){
                                                    System.out.println("Valor Invalido, informe um valor maior que zero ou menor igual a quantidade existente");
                                                }
                                            }while(product.getQtdEstoque() <= 0 || product.getQtdEstoque() > listaProdutos.get(codProduto).getQtdEstoque());
                                            System.out.println("CONFIRMA SAÍDA (S/N)?");
                                            resp = LerTexto.nextLine();
                                            if(resp.equals("S") || resp.equals("s")){
                                                System.out.println("SAÍDA CONFIRMADO");
                                                product.setQtdEstoque(listaProdutos.get(codProduto).getQtdEstoque() - product.getQtdEstoque());
                                                product.setPriceUnit(listaProdutos.get(codProduto).getPriceUnit());
                                                product.setUnit(listaProdutos.get(codProduto).getUnit());
                                                listaProdutos.set(codProduto, product);
                                            }else{
                                                System.out.println("SAÍDA NÃO CONFIRMADO");
                                            }


                                        }else{
                                            System.out.println("PRODUTO NÃO CADASTRADO");
                                        }

                                        break;
                                    case 0:
                                        System.out.println("Retorno para Menu Principal");
                                        break;

                                    default:
                                        System.out.println("\nOpção Inválida");
                                        break;

                                }
                            }while(op != 0);
                            op = 2;
                            break;
                        case 3:
                            aux = 0;
                            resp = "";
                            System.out.println("REAJUSTE DE PREÇOS");
                            product = new Produto();
                            System.out.print("INFORME O NOME DO PRODUTO: ");
                            product.setName(LerTexto.nextLine());
                            aux = verificarNomeProduto(listaProdutos, product.getName());
                            if(aux == 1){
                                int codProduto = 0;
                                System.out.println("Produto Existente");
                                codProduto = exibirPorPorduto(listaProdutos, product.getName());
                                do{
                                    System.out.print("INFORME O NOVO PREÇO: ");
                                    product.setPriceUnit(LerValor.nextDouble());
                                    if(product.getPriceUnit() <= 0){
                                        System.out.println("Valor Invalido, informe valor maior que zero");
                                    }
                                }while(product.getPriceUnit() <= 0);
                                product.setQtdEstoque(listaProdutos.get(codProduto).getQtdEstoque());
                                product.setUnit(listaProdutos.get(codProduto).getUnit());

                                System.out.println("CONFIRMA REAJUSTE (S/N)?");
                                resp = LerTexto.nextLine();
                                if(resp.equals("S") || resp.equals("s")){
                                    System.out.println("REAJUSTE CONFIRMADO");
                                    listaProdutos.set(codProduto, product);
                                }else{
                                    System.out.println("REAJUSTE NÃO CONFIRMADO");
                                }

                            }else{
                                System.out.println("PRODUTO NÃO CADASTRADO");
                            }

                            break;
                        case 4:
                            System.out.println("RELATÓRIOS");
                            if(listaProdutos.size()> 0){
                                relatorio(listaProdutos);
                            }else{
                                System.out.println("NÃO EXISTE PRODUTOS CADASTRADO");
                            }
                            break;
                        case 0:
                            System.out.println("Fim");
                            break;

                        default:
                            System.out.println("\nOpção Inválida");
                            break;
                    }

                }while(op != 0);

            }
            public static void Menu(){
                Cabecalho();
                System.out.print("MENU PRINCIPAL\n1 - CADASTRO DE PRODUTOS\n2 - MOVIMENTAÇÃO\n3 - REAJUSTE DE PREÇOS\n4 - RELATÓRIOS\n0 - FINALIZAR\nOPÇÃO: ");
            }
            public static void menuCadastroProduto(){
                Cabecalho();
                System.out.print("CADASTRO DE PRODUTOS\n1 - INCLUSÃO\n2 - ALTERAÇÃO\n3 - CONSULTA\n4 - EXCLUSÃO\n0 - RETORNAR\nOPÇÃO: ");
            }
            public static void menuMovimentacaoProduto(){
                Cabecalho();
                System.out.print("MOVIMENTAÇÃO\n1 - ENTRADA\n2 - SAIDA\n0 - RETORNAR\nOPÇÃO: ");
            }
            public static void Cabecalho(){

                System.out.println("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA.");
                System.out.println("SISTEMA DE CONTROLE DE ESTOQUE");

            }

            public static int verificarNomeProduto(List<Produto> p, String nome){
                int aux = 0;
                for (int i = 0; i < p.size(); i++) {
                    if(p.get(i).getName().equals(nome)){
                        aux = 1;
                        break;
                    }
                }
                return aux;
            }
            public static int exibirPorPorduto(List<Produto> p, String nome){
                int aux = 0;
                System.out.println("-----------------Produto---------------------------");
                for (int i = 0; i < p.size(); i++) {
                    if(p.get(i).getName().equals(nome)){
                        System.out.println(p.get(i).imprimir());
                        aux = i;
                        break;
                    }
                }
                System.out.println("---------------------------------------------------");
                return aux;
            }
            public static void consultaPorPorduto(List<Produto> p, String nome){
                System.out.println("-----------------Produto---------------------------");
                for (int i = 0; i < p.size(); i++) {
                    if(p.get(i).getName().equals(nome)){
                        System.out.println(p.get(i).imprimir());
                        break;
                    }
                }
                System.out.println("---------------------------------------------------");
            }
            public static void relatorio(List<Produto> p){
                System.out.println("-----------------Relatórios dos Produto---------------------------");
                for (int i = 0; i < p.size(); i++) {
                    System.out.println("---------------------------------------------------");
                    System.out.println(p.get(i).relatorio());

                }

            }







        // write your code here



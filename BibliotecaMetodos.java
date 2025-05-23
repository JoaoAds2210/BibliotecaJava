//Grupo: João Gomes, Ruth Cavalcante, Felipe Gomes, Pedro Souto, Caio Andrade //

package curso_programacao;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class BibliotecaMetodos {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		ArrayList <String> tituloLivro = new ArrayList <String>();
		ArrayList <String> autorLivro = new ArrayList <String>();

		System.out.println("Bem vindo à Biblioteca");
		int opcao = 0;
		
		while (opcao != 5) {
			exibirMenu();
			
			System.out.println("Digite a sua opção: ");
			opcao = sc.nextInt();
			sc.nextLine();
			
			switch (opcao) {
			case 1:
				adicionarLivro(sc, tituloLivro, autorLivro);
				break;
				
			case 2:
				pesquisarLivroPorTitulo (sc, tituloLivro, autorLivro);
				break;
				
			case 3:
				excluirLivro(sc, tituloLivro, autorLivro);
				break;
			
			case 4:
				listarLivros(tituloLivro, autorLivro);
				break;
			
			case 5:
				System.out.println("Obrigado por usar nosso sistema.");
				break;
			
			default:
				System.out.println("Opção Inválida.");
			}
		}
		sc.close();
		System.out.println("Saindo...");
	}
	
	public static void exibirMenu() {
		System.out.println("As nossas opções são:");
		System.out.println("1 -	Adicionar Novo Livro;");
		System.out.println("2 -	Pesquisar Livro por título;");
		System.out.println("3 -	Excluir livro pelo título;");
		System.out.println("4 -	Listar todos os Livros");
		System.out.println("5 -	Sair.");
	}
	
	public static void adicionarLivro(Scanner sc, ArrayList<String> tituloLivro, ArrayList<String> autorLivro) {
	    System.out.println("Digite o título do livro: ");
	    String titulo = sc.nextLine();
	    tituloLivro.add(titulo);

	    System.out.println("Digite o autor do livro: ");
	    String autor = sc.nextLine();
	    autorLivro.add(autor);
	    
	    System.out.println("Livro cadastrado com sucesso.");
	    
            for (int i = 0; i < tituloLivro.size(); i++) {
            	System.out.println(i + 1 + ": " + tituloLivro.get(i) + " | autor: " + autorLivro.get(i));
            }
	}
	
	public static void pesquisarLivroPorTitulo (Scanner sc, ArrayList <String> tituloLivro, ArrayList <String> autorLivro) {
		
		System.out.println("Digite o título do livro a ser pesquisado");
		String pesquisaTitulo = sc.nextLine().toLowerCase();
		
		boolean livroEncontrado = false;
		
		if (tituloLivro.isEmpty()) {
			System.out.println("Não há livros cadastrados!");
			}
		else {
			System.out.println("Os livros disponíveis são:");
			for (int i = 0; i < tituloLivro.size(); i++) {
	            if (tituloLivro.get(i).toLowerCase().contains(pesquisaTitulo)) {
	                System.out.println("Título: " + tituloLivro.get(i) + " | Autor: " + autorLivro.get(i));
	                livroEncontrado = true;
	                break;
	            }
	        }
	        if (!livroEncontrado) {
	            System.out.println("Nenhum livro encontrado com o título informado.");
	        }
	    }
	}
	
	public static void listarLivros(ArrayList<String> tituloLivro, ArrayList<String> autorLivro) {
		if (tituloLivro.isEmpty()) {
			System.out.println("Não há livros cadastrados!");
		}
		else {
			System.out.println("Nossos livros disponíveis são: ");
			for (int i = 0; i < tituloLivro.size(); i++) {
				System.out.println(i+1 + " - " + tituloLivro.get(i));
			}
		}
	}
	
	public static void excluirLivro(Scanner sc, ArrayList<String> tituloLivro, ArrayList <String> autorLivro) {
		System.out.println("Os livros disponíveis são: ");
		for (int i = 0; i < tituloLivro.size(); i++) {
			System.out.println(i + 1 + " - " + tituloLivro.get(i));
		}
		
			while(true) {
				System.out.println("Qual você deseja remover?");
				String removerFilme = sc.nextLine();
				if (removerFilme.isEmpty()) {
					System.out.println("Dados incorretos...");
				}
				else {
					if (tituloLivro.contains(removerFilme)) {
						int indice = tituloLivro.indexOf(removerFilme);
						tituloLivro.remove(indice);
						autorLivro.remove(indice);
						System.out.println("Filme: " + removerFilme + " - removido com sucesso!");
					}
					else {
						System.out.println("Livro não encontrado!");
					}break;
				} break;
			}
	}
}

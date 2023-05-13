package Teste;

import DAO.*;
import DTO.*;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		try (Scanner input = new Scanner(System.in)) {
			
			Usuario usuario = new Usuario();
			MetodosUsuario metodosUsuario = new MetodosUsuario();

			int opcao_menu;
			int opcao_editar;

			do {

				System.out.println(
						"\n________MENU________\n\n1 - CRIAR CONTA \n2 - FAZER LOGIN\n3 - FAZER LOGOUT\n4 - EDITAR CONTA\n5 - REMOVER CONTA\n6 - SAIR DA TELA\n");
				System.out.print("\nDigite a opção desejada: ");
				opcao_menu = input.nextInt();

				System.out.println();
				switch (opcao_menu) {

				case 1:

					input.nextLine();

					System.out.print("Digite o nome completo do usuario: ");
					String nome_usuario = input.nextLine();

					System.out.print("Digite o email do usuario: ");
					String email_usuario = input.nextLine();

					System.out.print("Digite uma senha de no minimo 8 digitos: ");
					String senha_usuario = input.nextLine();

					// System.out.println("Digite o caminho para o avatar: ");
					// String caminho_avatar = input.nextLine();

					usuario.setNomeCompleto(nome_usuario);
					usuario.setEmail(email_usuario);
					usuario.setSenha(senha_usuario);
					// usuario.setAvatar(imagemBytes);

					metodosUsuario.criarConta(usuario);
					break;

				case 2:

					input.nextLine();

					System.out.print("Email: ");
					String email_login = input.nextLine();

					System.out.print("Senha: ");
					String senha_login = input.nextLine();

					metodosUsuario.fazerLogin(email_login, senha_login);
					break;

				case 3:

					metodosUsuario.fazerLogout();
					break;

				case 4:

					do {
						if (metodosUsuario.getUsuarioLogado() != null) {

							System.out.println(
									"\n________MENU________\n\n1 - EDITAR NOME DE USUARIO\n2 - EDITAR EMAIL\n3 - EDITAR SENHA\n4 - EDITAR AVATAR\n5 - EDITAR TUDO\n6 - SAIR\n");
							opcao_editar = input.nextInt();

							switch (opcao_editar) {

							case 1:

								String nome_editado;

								input.nextLine();

								System.out.println("Olá " + metodosUsuario.getUsuarioLogado().getNomeCompleto() + "!");
								System.out.print("\nDigite o novo nome de usuário: ");
								nome_editado = input.nextLine();

								metodosUsuario.editarNomeUsuario(nome_editado);
								break;

							case 2:

								String email_editado;

								input.nextLine();

								System.out.println("Olá " + metodosUsuario.getUsuarioLogado().getNomeCompleto() + "!");
								System.out.print("\nDigite o novo email: ");
								email_editado = input.nextLine();

								metodosUsuario.editarEmail(email_editado);

								break;

							case 3:

								String senha_editada;

								input.nextLine();

								System.out.println("Olá " + metodosUsuario.getUsuarioLogado().getNomeCompleto() + "!");
								System.out.print("\nDigite a nova senha: ");
								senha_editada = input.nextLine();

								metodosUsuario.editarSenha(senha_editada);

								break;

							case 4:

								String avatar_editado;

								break;

							case 5:

								input.nextLine();

								System.out.println("Olá " + metodosUsuario.getUsuarioLogado().getNomeCompleto() + "!");
								
								System.out.print("\nDigite o novo nome completo: ");
								nome_editado = input.nextLine();
								System.out.print("Digite o novo e-mail: ");
								email_editado = input.nextLine();
								
								//System.out.print("Digite o novo caminho para o avatar: ");
								//avatar_editado = input.nextLine();
								
								System.out.println("\nDigite a senha atual: ");
								String senha_atual = input.nextLine();
								
								System.out.print("\nDigite a nova senha: ");
								senha_editada = input.nextLine();
								
								metodosUsuario.editarTudoUsuario(nome_editado, email_editado, senha_editada, senha_atual);

								break;

							}
						} else {
							System.out.println("O usuário precisa estar logado.");
							break;
						}

					} while (opcao_editar != 6);

				case 5:
					
					metodosUsuario.removerConta();
				}

			} while (opcao_menu != 6);
		}

	}

}

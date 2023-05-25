package Teste;

import DAO.*;
import DTO.*;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		try (Scanner input = new Scanner(System.in)) {

			Usuario usuario = new Usuario();
			MetodosUsuario metodosUsuario = new MetodosUsuario();
			Time time = new Time();
			MetodosTime metodosTime = new MetodosTime();

			int opcao_menu;
			int opcao_editar;
			int opcao_editar_time;

			do {

				System.out.println("\n________MENU________\n" 
									+ "\n1 - CRIAR CONTA "
									+ "\n2 - FAZER LOGIN"
									+ "\n3 - FAZER LOGOUT"
									+ "\n4 - EDITAR CONTA"
									+ "\n5 - REMOVER CONTA"
									+ "\n6 - INSERIR TIME"
									+ "\n7 - LISTAR TIMES"
									+ "\n8 - EDITAR TIME"
									+ "\n9 - REMOVER TIME"
									+ "\n10 - SAIR DA TELA\n");
				
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

					System.out.println("Digite o caminho para o avatar: ");
					String caminho_avatar = input.nextLine();

					usuario.setNomeCompleto(nome_usuario);
					usuario.setEmail(email_usuario);
					usuario.setSenha(senha_usuario);
					usuario.setAvatar(caminho_avatar);

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

								input.nextLine();

								System.out.println("Olá " + metodosUsuario.getUsuarioLogado().getNomeCompleto() + "!");
								System.out.print("\nDigite o novo caminho do avatar: ");
								avatar_editado = input.nextLine();

								metodosUsuario.editarAvatar(avatar_editado);

								break;

							case 5:

								input.nextLine();

								System.out.println("Olá " + metodosUsuario.getUsuarioLogado().getNomeCompleto() + "!");

								System.out.print("\nDigite o novo nome completo: ");
								nome_editado = input.nextLine();
								System.out.print("Digite o novo e-mail: ");
								email_editado = input.nextLine();

								System.out.print("Digite o novo caminho para o avatar: ");
								avatar_editado = input.nextLine();

								System.out.println("\nDigite a senha atual: ");
								String senha_atual = input.nextLine();

								System.out.print("\nDigite a nova senha: ");
								senha_editada = input.nextLine();

								metodosUsuario.editarTudoUsuario(nome_editado, email_editado, senha_editada,
										senha_atual, avatar_editado);

								break;

							}
						} else {
							System.out.println("O usuário precisa estar logado.");
							break;
						}

						break;

					} while (opcao_editar != 6);

				case 5:

					metodosUsuario.removerConta();
					break;

				case 6:

					if (metodosUsuario.getUsuarioLogado() != null) {

						input.nextLine();

						System.out.println("Digite o nome do time: ");
						String nome_time = input.nextLine();

						System.out.println("Coloque o caminho da imagem do escudo do time: ");
						String caminho_imagem_escudo = input.nextLine();

						System.out.println("Digite a abreviação do nome do time: ");
						String abreviacao_time = input.nextLine();

						time.setNome(nome_time);
						time.setAbreviacao(abreviacao_time);
						time.setImagem_escudo(caminho_imagem_escudo);

						metodosTime.criarTime(time, metodosUsuario.getUsuarioLogado().getId());

					} else {
						System.out.println("Nenhum usuário está logado.");
					}

					break;

				case 7:

					metodosTime.listarTimes();
					break;

				case 8:

					do {

						System.out.println("\n________MENU________\n" + "\n1 - EDITAR NOME " + "\n2 - EDITAR IMAGEM"
								+ "\n3 - EDITAR ABREVIAÇÃO" + "\n4 - EDITAR TUDO" + "\n5 - SAIR\n");

						System.out.print("\nDigite a opção desejada: ");
						opcao_editar_time = input.nextInt();

						switch (opcao_editar_time) {

						case 1:

							input.nextLine();

							String nome_time_editado;
							String nome_atual;

							System.out.print("Digite o nome do time que deseja editar: ");
							nome_atual = input.nextLine();

							System.out.print("Digite o novo nome do time: ");
							nome_time_editado = input.nextLine();

							metodosTime.editarNomeTime(nome_atual, nome_time_editado);
							
							break;

						case 2:

							input.nextLine();

							String imagem_atualizada;
							
							System.out.print("Digite o nome do time que deseja editar a imagem: ");
							nome_atual = input.nextLine();

							System.out.print("Digite o novo caminho da imagem do time: ");
							imagem_atualizada = input.nextLine();

							metodosTime.editarImagemTime(nome_atual, imagem_atualizada);
							break;
							
						case 3:
							
							input.nextLine();

							String abreviacao_atualizada;
							
							System.out.print("Digite o nome do time que deseja editar a abreviacao: ");
							nome_atual = input.nextLine();

							System.out.print("Digite a nova abreviação do time (no máximo 3 caracteres): ");
							abreviacao_atualizada = input.nextLine();

							metodosTime.editarAbreviacaoTime(nome_atual, abreviacao_atualizada);
							break;

						case 4:
							
							input.nextLine();
							
							System.out.print("Digite o nome do time que deseja editar as informacoes: ");
							nome_atual = input.nextLine();
							
							System.out.print("Digite o novo nome do time: ");
							nome_time_editado = input.nextLine();
							
							System.out.print("Digite o novo caminho da imagem do time: ");
							imagem_atualizada = input.nextLine();
							
							System.out.print("Digite a nova abreviação do time: ");
							abreviacao_atualizada = input.nextLine();
							
							metodosTime.editarTudoTime(nome_atual, nome_time_editado, imagem_atualizada, abreviacao_atualizada);
							break;
						}

					} while (opcao_editar_time != 5);
					
				case 9: 
					
					input.nextLine();
					
					System.out.print("Digite o nome do time que deseja remover: ");
					String nome_atual_remover = input.nextLine();
					
					metodosTime.removerTime(nome_atual_remover);
					
					break;
					
				}

			} while (opcao_menu != 10);
		}

	}

}

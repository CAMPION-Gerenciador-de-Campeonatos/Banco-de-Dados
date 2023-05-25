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
			Competicao competicao = new Competicao();
			MetodosCompeticao metodosCompeticao = new MetodosCompeticao();

			int opcao_menu;
			int opcao_editar;
			int opcao_editar_time;
			int opcao_editar_competicao;

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
						+ "\n10 - CRIAR COMPETICAO"
						+ "\n11 - LISTAR COMPETICAO" 
						+ "\n12 - EDITAR COMPETICAO"
						+ "\n13 - REMOVER COMPETICAO"
						+ "\n0 - SAIR DA TELA\n");

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
					if (metodosUsuario.getUsuarioLogado() != null) {
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

							metodosTime.editarTudoTime(nome_atual, nome_time_editado, imagem_atualizada,
									abreviacao_atualizada);
							break;
						}

					} while (opcao_editar_time != 5);
					
				} else {
					System.out.println("Nenhum usuário está logado.");
				}

				case 9:

					if(metodosTime.listarTimes() == null) {
						input.nextLine();

						System.out.println();
						
						System.out.print("Digite o ID do time que deseja remover: ");
						int id_atual_remover = input.nextInt();

						metodosTime.removerTime(id_atual_remover);

					} else {
						System.out.println("Não exite times cadastrados.");
					}
					
					break;

				case 10:

					if (metodosUsuario.getUsuarioLogado() != null) {

						input.nextLine();

						System.out.println("Digite o nome da competicao: ");
						String nome_competicao = input.nextLine();

						System.out.println("Digite uma descricao: ");
						String descricao_competicao = input.nextLine();

						System.out.println("Digite a quantidade de times desta competicao: ");
						int quantidade_times_competicao = input.nextInt();

						input.nextLine();

						System.out.println("Digite a premiação: ");
						String premiacao_competicao = input.nextLine();

						System.out.println("Digite o esporte: ");
						String esporte_competicao = input.nextLine();

						competicao.setNome(nome_competicao);
						competicao.setDescricao(descricao_competicao);
						competicao.setQuant_times(quantidade_times_competicao);
						competicao.setPremiacao(premiacao_competicao);
						competicao.setEsporte(esporte_competicao);

						metodosCompeticao.criarCompeticao(competicao);
	
					} else {
						System.out.println("Nenhum usuário está logado.");
					}

					break;

				case 11:

					metodosCompeticao.listarCompeticao();
					break;
				case 12:

					if (metodosUsuario.getUsuarioLogado() != null) {
						
						do {
							
							System.out.println("\n________MENU________\n" 
									+ "\n1 - EDITAR NOME " 
									+ "\n2 - EDITAR DESCRICAO"
									+ "\n3 - EDITAR QUANTIDADE TIMES" 
									+ "\n4 - PREMIACAO" 
									+ "\n5 - ESPORTE" 
									+ "\n6 - EDITAR TUDO" 
									+ "\n7 - SAIR\n");
							
							System.out.print("Digite a opcao desejada: ");
							opcao_editar_competicao = input.nextInt();
							
							switch(opcao_editar_competicao) {
							
							case 1: 
								input.nextLine();
								
								System.out.print("Digite o nome da competicão que deseja editar: ");
								String nome_competicao_atual = input.nextLine();
								
								System.out.print("Digite o novo nome: ");
								String nome_atualizado = input.nextLine();
								
								metodosCompeticao.editarNomeCompeticao(nome_competicao_atual, nome_atualizado);
								
								break;
								
							case 2:
								
								input.nextLine();
								
								System.out.print("Digite o nome da competicão que deseja editar a descrição: ");
								nome_competicao_atual = input.nextLine();
								
								System.out.print("Digite a nova descrição: ");
								String descricao_atualizada = input.nextLine();
								
								metodosCompeticao.editarDescricaoCompeticao(nome_competicao_atual, descricao_atualizada);
								
								break;
								
							case 3: 
								
								input.nextLine();
								
								System.out.print("Digite o nome da competicão que deseja editar a quantidade de times: ");
								nome_competicao_atual = input.nextLine();
								
								System.out.print("Digite a nova quantidade de times: ");
								int quant_times_atualizado = input.nextInt();
								
								metodosCompeticao.editarQuantidadeTimesCompeticao(nome_competicao_atual, quant_times_atualizado);
								
								break;
								
							case 4: 
								
								input.nextLine();
								
								System.out.print("Digite o nome da competicão que deseja editar a premiação: ");
								nome_competicao_atual = input.nextLine();
								
								System.out.print("Digite a nova premiação: ");
								String premiacao_atualizada = input.nextLine();
								
								metodosCompeticao.editarPremiaçãoCompeticao(nome_competicao_atual, premiacao_atualizada);
								
								break;
								
							case 5:
								input.nextLine();
								
								System.out.print("Digite o nome da competicão que deseja editar o esporte: ");
								nome_competicao_atual = input.nextLine();
								
								System.out.print("Digite o novo esporte: ");
								String esporte_atualizado = input.nextLine();
								
								metodosCompeticao.editarEsporteCompeticao(nome_competicao_atual, esporte_atualizado);
								
								break;
							case 6:
								input.nextLine();
								
								System.out.print("Digite o nome da competicão que deseja editar: ");
								nome_competicao_atual = input.nextLine();
								
								System.out.print("Digite o novo nome: ");
								nome_atualizado = input.nextLine();
								
								System.out.print("Digite a nova descrição: ");
								descricao_atualizada = input.nextLine();
								
								System.out.print("Digite a nova quantidade de times: ");
								quant_times_atualizado = input.nextInt();
								
								input.nextLine();
								
								System.out.print("Digite a nova premiação: ");
								premiacao_atualizada = input.nextLine();
								
								System.out.print("Digite o novo esporte: ");
								esporte_atualizado = input.nextLine();
								
								metodosCompeticao.atualizarTudoCompeticao(nome_competicao_atual, nome_atualizado, descricao_atualizada, quant_times_atualizado, premiacao_atualizada, esporte_atualizado);
								
								break;
								
							}
							
						}while(opcao_editar_competicao != 7);
						
						
					}else {
						System.out.println("Nenhum usuário está logado.");
					}
					
					break;
					
				case 13:
					
					metodosCompeticao.listarCompeticao();
					
					System.out.println();
					
					System.out.print("Digiteo ID da competicao que você deseja remover: ");
					int remover_competicao = input.nextInt();
					
					metodosCompeticao.removerCompeticao(remover_competicao);
					break;

				}
			} while (opcao_menu != 0);
		}
	}
}

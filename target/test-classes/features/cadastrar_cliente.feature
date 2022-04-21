#language: pt

@cliente
Funcionalidade: Cadastro de clientes
	Como um colaborador do banco bajax 
	Eu quero cadastrar clientes
	Para a criação de novas contas no banco
	
Cenário: deve criar cliente com sucesso
	Dado que possuo as informações válidas de um individuo
	Quando crio um cliente com essas informações
	Então o cliente é cadastrado com sucesso

Cenário: cliente inválido campos obrigatórios nulos
	Dado que possuo as informações para criar um cliente a partir da lista
	| Yuri Azul | yuri@gmail.com | 123456789-11 | true |
	# Quando adiciono o "<campo>" como nulo
	# Então ao tentar criar o cliente recebo a mensagem de erro "<mensagem>"

Esquema do Cenário: cliente inválido campos obrigatórios vazios
	Dado que possuo as informações válidas de um individuo
	Quando adiciono o "<campo>" vazio
	Então ao tentar criar o cliente recebo a mensagem de erro "<mensagem>"
	
Exemplos:
	|     campo      |       mensagem       |
	|     nome       |   Dados inválidos!   |
	|     email      |   Dados inválidos!   |
	|     cpf        |   Dados inválidos!   |
	|     ativo      |   Dados inválidos!   |

Esquema do Cenário: cliente inválido campos obrigatórios no formato inválido
	Dado que possuo as informações válidas de um individuo
	Quando adiciono o "<campo>" no formato inválido
	Então ao tentar criar o cliente recebo a mensagem de erro "<mensagem>"
	
Exemplos:
	|     campo      |       mensagem       |
	|     nome       |   Dados inválidos!   |
	|     email      |   Dados inválidos!   |
	|     cpf        |   Dados inválidos!   |
	|     ativo      |   Dados inválidos!   |

Cenário: adicionar telefone no formato inválido
	Dado que tenho um cliente válido
	Quando adiciono um telefone no formato inválido
	Então recebo uma mensagem de erro

Cenário: alterar campo ativo para nulo
	Dado que tenho um cliente válido
	Quando tento alterar o campo ativo para nulo
	Então recebo uma mensagem de erro
  
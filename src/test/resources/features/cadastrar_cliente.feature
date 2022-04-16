#language: pt
Funcionalidade: Cadastro de clientes

	Como um colaborador do banco bajax 
	Eu quero cadastrar clientes
	Para a criação de novas contas no banco
	
Cenário: deve criar cliente com sucesso
	Dado que crio um cliente válido
	Quando imprimir o cliente
	Então as informações sobre ele são exibidas

Esquema do Cenário: cliente inválido campos obrigatórios nulos
	Dado que desejo criar um cliente
	Quando adiciono o "<campo>" como nulo
	Então recebo a mensagem de erro "<mensagem>"
	
Exemplos:
	|     campo      |       mensagem       |
	|     nome       |   Dados inválidos!   |
	|     email      |   Dados inválidos!   |
	|     cpf        |   Dados inválidos!   |
	|     ativo      |   Dados inválidos!   |

Cenário: cliente inválido campos obrigatórios vazios
	Dado que desejo criar um cliente
	Quando adiciono o campo vazio
	Então recebo a mensagem de erro

Cenário: cliente inválido campos obrigatórios no formato inválido
	Dado que desejo criar um cliente
	Quando adiciono um campo no formato inválido
	Então recebo a mensagem de erro

Cenário: adicionar telefone no formato inválido
	Dado que tenho um cliente válido
	Quando adiciono um telefone no formato inválido
	Então recebo uma mensagem de erro

Cenário: alterar campo ativo para nulo
	Dado que tenho um cliente válido
	Quando tento alterar o campo ativo para nulo
	Então recebo uma mensagem de erro
  
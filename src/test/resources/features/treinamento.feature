#language: pt

Funcionalidade: Acessar o sistema

  Contexto:
    Dado que acesso à página

  Esquema do Cenário: Acessar web
    E informo um nome "<nome>"
    E informo um sobre "<sobrenome>"

    Exemplos:
      | nome    | sobrenome |
      | Rodolfo | Farley    |
      | Luna    | Veloso    |
      | Pedro   | oi      |



#    Cenario: Inserir dados segundo
#      E informo os campos
#      | campo     | dados   |
#      | nome      | Rodolfo |
#      | sobrenome | Farley  |


#
#  Feature: Testes automatizados do Campo de Treinamento 2 - cenários outline
#
#  Background:
#  Given que navego à aplicação "https://mediumseagreen-sheep-627446.hostingersite.com/"
#
#  Scenario Outline: Testes de cadastro de pessoa de qualquer gênero
#  And preenche o campo '<nome>'
#  And preenche o campo sobrenome '<sobrenome>'
#  And preenche o campo genero '<genero>'
#  And preenche o campo escolaridade '<escolaridade>'
#  And preenche o campo esportes '<esportes>'
#  And preenche o campo comida '<comida>'
#  And preenche o campo sugestoes '<sugestoes>'
#  Then o cadastro deve ser realizado com sucesso
#
#  Examples:
#  | nome  | sobrenome | genero   | escolaridade | esportes | comida      | sugestoes |
#  | Maria | Carvalho  | feminino | superior     | karatê   | vegetariana | nenhuma   |
#  | João  | Silva     | masculino| médio        | futebol  | carnívora   | sem       |

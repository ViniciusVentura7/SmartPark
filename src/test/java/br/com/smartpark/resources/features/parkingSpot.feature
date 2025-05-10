Feature: Gerenciamento de vagas de estacionamento

  Scenario: Cadastro de vaga com sucesso
    Given que o usuário deseja cadastrar uma nova vaga
    When ele envia um POST com endereço "Av. Brasil, 100", latitude -23.55 e longitude -46.63
    Then o sistema deve retornar status 200
    And o corpo da resposta deve conter o campo "disponivel" com valor true

  Scenario: Listar vagas disponíveis
    Given que existem vagas cadastradas como disponíveis
    When o usuário envia um GET para /api/vagas
    Then o sistema deve retornar status 200
    And o corpo da resposta deve ser uma lista com pelo menos 1 item

  Scenario: Buscar vaga inexistente por ID
    Given que nenhuma vaga existe com ID 9999
    When o usuário envia um GET para /api/vagas/9999
    Then o sistema deve retornar status 500
    And o corpo da resposta deve conter a mensagem "Vaga não encontrada"

# Desafio Uol Compase

RF1 - Receber objeto contendo código do vendedor e lista de pagamentos:

O sistema deve ser capaz de receber um objeto que contenha o código do vendedor e uma lista de pagamentos, onde cada pagamento é associado a um código de cobrança.
RF2 - Validar existência do vendedor:

O sistema deve consultar a base de dados para verificar se o vendedor existe. Caso o vendedor não seja encontrado, o sistema deve retornar uma mensagem de erro informando que o vendedor não foi encontrado.
RF3 - Validar existência do código da cobrança:

Para cada pagamento na lista, o sistema deve verificar a existência do código da cobrança na base de dados. Caso o código não seja encontrado, o sistema deve retornar uma mensagem de erro informando que o código da cobrança não foi encontrado.
RF4 - Validar valor do pagamento:

O sistema deve comparar o valor de cada pagamento com o valor original da cobrança:
Pagamento parcial: Valor do pagamento é inferior ao valor da cobrança.
Pagamento total: Valor do pagamento é igual ao valor da cobrança.
Pagamento excedente: Valor do pagamento é superior ao valor da cobrança.
RF5 - Enviar objeto para fila SQS:

Dependendo do status do pagamento (parcial, total ou excedente), o sistema deve enviar o objeto para a fila SQS apropriada.
Fila para pagamentos parciais
Fila para pagamentos totais
Fila para pagamentos excedentes
RF6 - Preencher status de pagamento:

O sistema deve preencher o status de pagamento (parcial, total ou excedente) no próprio objeto antes de retornar a resposta.

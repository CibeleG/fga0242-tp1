# Elegância

## Descrição

A elegância incorpora os aspectos estéticos do design e muitas vezes anda de mãos dadas com a simplicidade. Demonstra então como o código não é excessivamente complexo. As características desejáveis são:
* Possuir um controle fluido ao redor do sistema;
* Cada parte se complementa;
* O design não fica inchado com casos especiais ou específicos;
* Associa os coisas que são semelhantes umas com as outras;
* Uma única alteração não provoca a necessidade de modificações em outra parte do código

## Relação com mal-cheiros
Os principais maus-cheiros que a ausência de duplcidades se relaciona são:
- Longa lista de parametros: Listas de parâmetros longas;
- Classe preguiçosa: Classes que não possuem comportamento suficiente para ser mantida no projeto, ou seja, pequena demais deve ser eliminada do projeto;
- Cirurgia com rifle: Uma mudança que afeta várias classes;


## Operação de Refatoração

- Longa lista de parametros:
  - Introduzir objeto-parâmetro: para substituir um conjunto de dados que não estão logicamente relacionados por um objeto de dados.
- Classe preguiçosa:
  - Mover método e mover atributo: de modo a levar os elementos presentes na classe para outras classes em que são mais indicados.
- Cirurgia com rifle:
  - Incorporar classe: para agrupar um conjunto de comportamentos em uma única estrutura (aumentar a coesão, caso ela tenha sido afetada com a movimentação de métodos e campos).
# Simplicidade

## Descrição

Um design simples é claro e de fácil entendimento, não possui manchas desnecessárias e é facil de ser implementado, ele é o menor possível. Coerente e consistente. 

## Relação com mal-cheiros

Os principais maus-cheiros que a ausência de duplcidades se relaciona são:
- Classe inchada: Quando uma classe apresenta muitas variáveis de instâncias é indício de que ela está com coesão baixa (fazendo mais do que deveria);
- Generalidade especulativa: O projetista fez previsões de funcionalidades que algum dia poderiam vir a ser implementadas;
- Método longo: Método grande que pode ser convertido em métodos menores;


## Operação de Refatoração
- Classe inchada
  - Extrair método: Sempre que necessário diminuir o tamanho de um método. 
- Generalidade especulativa:
  - Extrair subclasse: Para agrupar um número de variáves que fazem sentido como uma subclasse da classe em que estão. 
- Método longo
  - Incorporar classe: para agrupar um conjunto de comportamentos em uma única estrutura (aumentar a coesão, caso ela tenha sido afetada com a movimentação de métodos e campos).
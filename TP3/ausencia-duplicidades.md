# Ausência de duplicidades

## Descrição
uma descrição da característica, mostrando claramente quais são os seus efeitos no código (em termo de estrutura, claridade, coesão, acoplamento dentre outros efeitos aplicáveis);

Essa característica se refere a evitar que no sistema tenha trechos diferentes que desempenhem a mesma função. 
O objetivo é desenvolver códigos curtos e que tenham uma única função, para evitar que eles sejam confusos e também diminuir a sua complexidade.
A ausência de duplicidade impacta principalmente na claridade, complexidade e coesão. 
- Claridade: vários trechos de código com a mesma função deixam o código confuso e dificultam o entendimento.
- Complexidade: repetições de funções, principalmente com estruturas condicionais, aumentam a complexidade do código e aumentam o tempo de execução.
- Coesão: se o trecho duplicado tiver um bug ou precisar de alterações, todos os trechos com o mesmo código precisam ser alterados. 

Uma forma de prevenir esses problemas é utilizando princípios de programação orientada a objetos, como o encapsulamento, que contribui para deixar o código mais limpo e funcional.

## Relação com maus-cheiros

Os principais maus-cheiros que a ausência de duplcidades se relaciona são:
- Código duplicado;
- Classes alternativas com interfaces diferentes: apesar de terem assinaturas diferentes, realizam as mesmas funções, indicando código duplicado;
- Hierarquias de herança paralelas: ao modificar uma classe tem que modificar outra classe diferente, também indica duplicidade no código; 


## Operação de Refatoração
Para cada mau-cheiro relacionado:
- Código duplicado:
    - Extrair método;
- Classes alternativas com interfaces diferentes:
    - Renomear método;
    - Mover método; 
    - Extrair método e chamar nas classes as quais os métodos estavam ligados;
- Hierarquias de herança paralelas:
    - Mover método e mover campo;
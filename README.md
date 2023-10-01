# unesp-ia-buscas

Exercícios de busca local para disciplina de inteligência artificial do programa de mestrado, o desafio era partir da cidade I e ir até F comparando os diferentes métodos: Hill Climbing, Best First, Custo Uniforme e A*
## Cenário
<img src="./cenario.svg">

### App.java, na primeira abordagem tem a seguinte saída utilizando o método Hill Climbing
```
Finding a path from I to F
            The closest neighbour from I is A you can go there in 3 minutes.
            The closest neighbour from A is B you can go there in 3 minutes.
            The closest neighbour from B is C you can go there in 4 minutes.
            The closest neighbour from C is D you can go there in 3 minutes.
            The closest neighbour from D is E you can go there in 2 minutes.
            The closest neighbour from E is G you can go there in 3 minutes.
            The closest neighbour from G is H you can go there in 3 minutes.
            The closest neighbour from H is K you can go there in 2 minutes.
            The closest neighbour from K is F you can go there in 8 minutes.
        We have arrived at F
```
import numpy as np
import time

def bubble_sort(original_array):
    resultado = []
    for v in original_array:
        resultado.append(v)

    n = len(resultado)

    for i in range(n):
        trocou = False
        for j in range(0, n - i - 1):
            if resultado[j] > resultado[j + 1]:
                temporario = resultado[j]
                resultado[j] = resultado[j + 1]
                resultado[j + 1] = temporario
                trocou = True
        if not trocou:
            break

    return resultado


def gera_array_aleatorio(tamanho, limite_inferior=0, limite_superior=100000):
    return np.random.randint(limite_inferior, limite_superior, size=tamanho)


def mede_tempo(algoritmo, tamanho, repeticoes):
    tempos_ns = []

    for r in range(repeticoes):
        base = gera_array_aleatorio(tamanho)

        if algoritmo == "bubble":
            dados_para_ordenar = base.tolist()
            inicio_ns = time.perf_counter_ns()
            bubble_sort(dados_para_ordenar)
            fim_ns = time.perf_counter_ns()

        elif algoritmo in ("quicksort", "mergesort"):
            dados_para_ordenar = base.copy()
            inicio_ns = time.perf_counter_ns()
            np.sort(dados_para_ordenar, kind=algoritmo)
            fim_ns = time.perf_counter_ns()

        else:
            raise ValueError("Algoritmo desconhecido: " + str(algoritmo))

        duracao_ns = fim_ns - inicio_ns
        tempos_ns.append(duracao_ns)

    # média em nanos
    media_ns = sum(tempos_ns) / len(tempos_ns)
    # converte para microsegundos
    media_us = media_ns / 1000.0
    return media_us


def main():
    tamanhos = [1000, 1000, 1000, 5000, 5000, 5000, 10000, 10000, 10000]
    repeticoes = 5
    algoritmos = ["bubble", "quicksort", "mergesort"]

    # (tempo em microsegundos)
    print("{:<10} {:>18} {:>18} {:>18}".format("Tamanho", "Bubble (µs)", "Quick (µs)", "Merge (µs)"))

    for tamanho in tamanhos:
        resultados = {}
        for alg in algoritmos:
            tempo_med_us = mede_tempo(alg, tamanho, repeticoes)
            resultados[alg] = tempo_med_us

        print("{:<10} {:>18.3f} {:>18.3f} {:>18.3f}".format(
            tamanho,
            resultados["bubble"],
            resultados["quicksort"],
            resultados["mergesort"]
        ))


if __name__ == "__main__":
    main()

public class Main {
    public static void main(String[] args) throws estruturaVaziaException {
        Lista lista = new Lista();
        lista.adicionarInicio(3);
        lista.adicionarInicio(2);
        lista.adicionarInicio(1);
        lista.adicionarFinal(4);
        lista.printarLista();
        System.out.println();
        lista.adicionarNaPosicao(0,1);
        lista.printarLista();
    }
}

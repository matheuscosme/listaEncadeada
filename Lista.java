public class Lista {
    private No inicioLista;


    public Lista(){
        this.inicioLista = null;
    }


    public boolean listaVazia(){
        if (this.inicioLista == null){
            return true;
        }
        else {
            return false;
        }
    }


    public void adicionarInicio(int valor){
        No novo = new No(valor);

        if (!this.listaVazia()){
            novo.proximoNo = this.inicioLista;
        }
        this.inicioLista = novo;
    }


    public void adicionarFinal(int valor){
        No novo = new No(valor);

        if (this.listaVazia()){
            this.inicioLista = novo;
        }
        else{
            No aux = this.inicioLista;
            while(aux.proximoNo != null){
                aux = aux.proximoNo;
            }
            aux.proximoNo = novo;
        }
    }


    public No removerInicio() throws estruturaVaziaException{
        No removido = null;

        if(this.listaVazia()){
            throw new estruturaVaziaException();
        }
        else{
            removido = inicioLista;
            inicioLista = inicioLista.proximoNo;
        }

        return removido;
    }


    public No removerFinal() throws estruturaVaziaException{
        No removido = null;
        No aux;
        if (this.listaVazia()){
            throw new estruturaVaziaException();
        }
        else{
            removido = aux = this.inicioLista;
            while(removido.proximoNo != null){
                aux = removido;
                removido = removido.proximoNo;
            }
            aux.proximoNo = null;
        }

        return removido;
    }


    public void adicionarNaPosicao(int valor, int posicao){
        if(this.listaVazia() || posicao <= 0){
            this.adicionarInicio(valor);
        }
        else{
            No novo = new No(valor);
            No aux = this.inicioLista;
            int indice = 1;
            while(indice<posicao && aux != null){
                aux = aux.proximoNo;
                indice++;
            }
            if(aux == null){
                this.adicionarFinal(valor);
            }
            else{
                novo.proximoNo = aux.proximoNo;
                aux.proximoNo = novo;
            }
        }
    }


    public No removerNaPosicao(int posicao) throws estruturaVaziaException{
        No removido = null;
        No aux;
        if(this.listaVazia() || posicao<=0){
            removido = removerInicio();
        }
        else{
            removido = aux = this.inicioLista;
            int indice = 0;
            while(indice<posicao && removido != null){
                aux = removido;
                removido = removido.proximoNo;
                indice++;
            }
            if (removido == null){
                removido = this.removerFinal();
            }
            else{
                aux.proximoNo = removido.proximoNo;
            }
        }

        return removido;
    }

    
        public No retornarUltimo(){
        No ultimo = null;
        ultimo = this.removerFinal();
        this.adicionarFinal(ultimo);

        return ultimo;
    }

    public No retornarPenultimo(){
        No ultimo, penultimo;
        ultimo = this.removerFinal();
        penultimo = this.removerFinal();
        this.adicionarFinal(penultimo);
        this.adicionarFinal(ultimo);

        return penultimo;
    }


    public No retornarNaPosicao(int posicao){
        No elemento;
        elemento = this.removerNaPosicao(posicao);
        this.adicionarNaPosicao(posicao);

        return elemento;
    }

    

    public void printarLista(){
        No noAtual;
        noAtual = inicioLista;
        while(noAtual != null){
            System.out.println(noAtual.elementoArmazenado);
            noAtual = noAtual.proximoNo;
        }
    }
}

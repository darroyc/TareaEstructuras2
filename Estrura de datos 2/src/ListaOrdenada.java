import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ListaOrdenada {
    Nodo raiz = new Nodo();

    void lista() {
        ListaOrdenada lista = new ListaOrdenada();

        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);
        String continuar = "s";

        while(continuar.equals("s")){
            try {
                System.out.println("1) Ingresar a la lista./n 2) Extraer de la lista: ");
                String opcion=br.readLine();

                if(opcion.equals("1")){
                    System.out.println("Cual numero desea ingresar a la lista? ");
                    int num = Integer.parseInt(br.readLine());

                    lista.insertar(num);
                }

                lista.imprimir();

                System.out.println("Desea continuar? (s/n) ");
                continuar=br.readLine();
                continuar.toLowerCase();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    private void insertar(int x){
        Nodo nuevo = new Nodo();
        nuevo.dato = x;

        if (raiz == null){
            raiz = nuevo;
        }else{
            if (x < raiz.dato){
                nuevo.proximo = raiz;
                raiz = nuevo;
            }else{
                Nodo reco = raiz;
                Nodo atras = raiz;

                while (x >= reco.dato && reco.proximo != null){
                    atras = reco;
                    reco = reco.proximo;
                }

                if(x >= reco.dato){
                    reco.proximo = nuevo;
                }else{
                    nuevo.proximo = reco;
                    atras.proximo = nuevo;
                }
            }
        }

    }

    private void imprimir(){
        Nodo reco = raiz;
        System.out.println("Listado completo.\n");
        while (reco != null)
        {
            System.out.println(reco.dato + "-");
            reco = reco.proximo;
        }
    }

}

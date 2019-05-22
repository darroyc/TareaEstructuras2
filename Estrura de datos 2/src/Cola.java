import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cola {
    private Nodo raiz,fondo;

    Cola() {
        raiz=null;
        fondo=null;
    }

    void colas() {
        Cola cola = new Cola();

        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);
         String continuar = "s";

         while(continuar.equals("s")){
             try {
                 System.out.println("1) Ingresar a la cola./n 2) Extraer de la cola: ");
                 String opcion=br.readLine();

                 if(opcion.equals("1")){
                     System.out.println("Cual numero desea ingresar a la cola? ");
                     int num = Integer.parseInt(br.readLine());

                     cola.insertar(num);
                 }else{
                     System.out.println("Extraemos uno de la cola:" + cola.extraer());
                 }

                 cola.imprimir();

                 System.out.println("Desea continuar? (s/n) ");
                 continuar=br.readLine();
                 continuar.toLowerCase();

             } catch (IOException e) {
                 e.printStackTrace();
             }
        }


    }

    boolean vacia (){
        if (raiz == null)
            return true;
        else
            return false;
    }

    void insertar (int info)
    {
        Nodo nuevo;
        nuevo = new Nodo ();
        nuevo.dato = info;
        nuevo.proximo = null;

        if (vacia ()) {
            raiz = nuevo;
            fondo = nuevo;
        } else {
            fondo.proximo = nuevo;
            fondo = nuevo;
        }
    }

    int extraer ()
    {
        if (!vacia ())
        {
            int informacion = raiz.dato;
            if (raiz == fondo){
                raiz = null;
                fondo = null;
            } else {
                raiz = raiz.proximo;
            }
            return informacion;
        } else
            return Integer.MAX_VALUE;
    }

    public void imprimir() {
        Nodo reco=raiz;
        System.out.println("Listado de todos los elementos de la cola.");
        while (reco!=null) {
            System.out.print(reco.dato+",");
            reco=reco.proximo;
        }
        System.out.println();
    }


}

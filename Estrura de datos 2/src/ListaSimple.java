public class ListaSimple {
    static Nodo cabeza;

    public static void lista(){

    ListaSimple listaSimple = new ListaSimple();

    ListaSimple.cabeza  = new Nodo(1);
    Nodo segundo = new Nodo(2);
    Nodo tercero  = new Nodo(3);

        /* Three nodes have been allocated  dynamically.
          We have refernces to these three blocks as first,
          second and third

         +----+------+     +----+------+     +----+------+
         | 1  | null |     | 2  | null |     |  3 | null |
         
          llist.head        second              third
             |                |                  |
             |                |                  |+----+------+     +----+------+     +----+------+ */

        listaSimple.cabeza.proximo = segundo; // Link first node with the second node

        /*  Now next of first Node refers to second.  So they
            both are linked.

         llist.head        second              third
            |                |                  |
            |                |                  |
        +----+------+     +----+------+     +----+------+
        | 1  |  o-------->| 2  | null |     |  3 | null |
        +----+------+     +----+------+     +----+------+ */

    segundo.proximo = tercero; // Link second node with the third node

        /*  Now next of second Node refers to third.  So all three
            nodes are linked.

         llist.head        second              third
            |                |                  |
            |                |                  |
        +----+------+     +----+------+     +----+------+
        | 1  |  o-------->| 2  |  o-------->|  3 | null |
        +----+------+     +----+------+     +----+------+ */
        // Print the name from the list....
        listaSimple.printList();
    }

    public void printList()
    {
        Nodo n = cabeza;
        while (n != null)
        {
            System.out.print(n.dato+" ");
            n = n.proximo;
        }
    }
}

public final class Vertices {
    int v1=-1, v2=-1;
    Vertices(){

    }
    Vertices(int v1){
        this.v1=v1;
    }
    Vertices(Integer[] args){
        if (args.length > 0)
            v1 = args[0];
        if (args.length > 1)
            v2 = args[1];
    }
    Vertices(int v1, int v2){
        this.v1=v1;
        this.v2=v2;
    }

    @Override
    public String toString()
    {
        return "Vertices{" + "v1=" + v1 + ", v2=" + v2 + '}';
    }
}
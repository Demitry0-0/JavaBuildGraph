public class Pair<T1, T2> {
    T1 first;
    T2 second;

    Pair(T1 f, T2 s)
    {
        first = f;
        second = s;
    }

    @Override
    public String toString()
    {
        return "Pair{" + "first=" + first + ", second=" + second + '}';
    }
}

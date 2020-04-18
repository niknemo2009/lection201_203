import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lection170420 {

    public static void main(String[] args) {
        //"qwe".substring(3)
        Comparator<String> qwe=(String q,String d)-> {
            return q.substring(3).compareTo(d.substring(3));
        };
          //  public int compare(String o1, String o2) {

        List<String> list=new ArrayList();
        list.add("qwerty");
        list.add("asberty");
        list.add("qwerty");
        list.add("qwberty");
        list.add("qwerty");
        list.add("qwcrty");

        Collections.sort(list,qwe);
        System.out.println(list);

        Consumer<String> consumer= w->{
            System.out.println(w);
        };
          //  public void accept(String s) {

        Function<String,Integer> function=f->f.length();
          //  public Integer apply(String s) {
          // signatura =name_metod+count_parametrs+type+ order
        Predicate<String> predicate=row->row.length()>5;
         //   public boolean test(String s) {
               Lection170420 var=new Lection170420();
        System.out.println(var.<String>filtr(list,r->r.substring(3,4).equals("e")));
        List<Integer>  list33=new ArrayList<>();
        list33.add(1);
        list33.add(12);
        list33.add(11);
        list33.add(13);
        list33.add(14);
        Predicate<Integer>  qwe33=r->r>10;
        System.out.println(var.<Integer>filtr(list33,qwe33.and(t->t%2==0)));

        }

       <T> List<T>  filtr(Collection<T> collect, Predicate<T> condition){
        List<T> result=new ArrayList<>();
        for(T temp:collect){

            if(condition.test(temp)==true){

                result.add(temp);
            }
        }
        return  result;
        }


    }




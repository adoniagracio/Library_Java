package Library;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class db<T> {
    private String name;
    private ArrayList<T> list = new ArrayList<T>();
    
    public db(String name){
        this.name = name;
    }
    
    public void add(T toAdd){
        System.out.println("Entry added to: " + this.name);
        list.add(toAdd);
    }

    public void addIndex(int selectedRow, T toAddT) {
        list.add(selectedRow, toAddT);
    }

    public void remove(int IndexToRemove){
        System.out.println(this.name + " " + IndexToRemove + " removed!");
        list.remove(IndexToRemove);
    }
    
    public void update(int IndexToUpdate, T newValue){
        System.out.println(this.name + " " + IndexToUpdate + " updated!");
        list.set(IndexToUpdate, newValue);
    }

    public void Save() {
        try (FileOutputStream fos = new FileOutputStream("src/"+ this.name + ".bin");
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this.list);
            System.out.println("Save \"" + this.name +  "\" Success!");
        } catch (IOException e) {
            System.out.println("Save \"" + this.name +  "\" Error!");
        }
    }
    
   @SuppressWarnings("unchecked")
    public void Load() {
        ArrayList<T> list = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream("src/"+ this.name + ".bin");
                ObjectInputStream ois = new ObjectInputStream(fis)) {
                    list = (ArrayList<T>) ois.readObject();
                    System.out.println("Load \"" + this.name +  "\" Success!");
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println("Load \"" + this.name +  "\" Error!");
        }
        this.list = list;
    }

    public ArrayList<T> getList(){
        return this.list;
    }

    public T getIndex(int index){
        return list.get(index);
    }

    public int getSize(){
        return list.size();
    }
    
    public void printData(){
        for (T element : list) {
            System.out.println(element);
        }
    }
}
package ui.smartpro.notebook;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.UUID;

public class Notebook implements Comparable<Notebook> {
    UUID id = UUID.randomUUID();
    Producer producer;
    BigDecimal price;
    int memory;

    public Notebook(Producer producer, BigDecimal price, int memory) {
        this.producer = producer;
        this.price = price;
        this.memory = memory;
    }

    public enum Producer {
        XAMIOU, ESER, MACNOTE, ASOS, LENUVO
    }

    public UUID getId() {
        return id;
    }

    public Producer getModel() {
        return producer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public long getMemory() {
        return memory;
    }

    public Notebook(UUID id, Producer producer, BigDecimal price, int memory) {
        this.id = id;
        this.producer = producer;
        this.price = price;
        this.memory = memory;
    }

    @Override
    public int compareTo(Notebook n) {
        int result = price.compareTo(n.getPrice());
        if (result == 0) {
            result =  Integer.compare(memory, (int) n.getMemory());
            if (result == 0) {
                return producer.compareTo(n.getModel());
            }
            return result;
        }
        return result;
    }

    //Comparator для сортировки списка или массива объектов по Памяти
    public static Comparator<Notebook> SalaryComparator = new Comparator<Notebook>() {

        @Override
        public int compare(Notebook e1, Notebook e2) {
            return (int) (e1.getMemory() - e2.getMemory());
        }
    };

    //Comparator для сортировки списка или массива объектов по Цене
//    public static Comparator<Notebook> AgeComparator = new Comparator<Notebook>() {
//
//        @Override
//        public int compare(Notebook e1, Notebook e2) {
//            return e1.getPrice() - e2.getPrice();
//        }
//    };

    //Comparator для сортировки списка или массива объектов по имени
    public static Comparator<Notebook> NameComparator = new Comparator<Notebook>() {

        @Override
        public int compare(Notebook e1, Notebook e2) {
            return e1.getModel().compareTo(e2.getModel());
        }
    };
}

package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TRANSACTED_PRODUCTS", schema = "Database", catalog = "")
public class TransactedProductsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "ID_TRANSACTION", nullable = false)
    private int idTransaction;
    @Basic
    @Column(name = "ID_PRODUCT", nullable = false)
    private int idProduct;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactedProductsEntity that = (TransactedProductsEntity) o;
        return id == that.id && idTransaction == that.idTransaction && idProduct == that.idProduct;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idTransaction, idProduct);
    }
}

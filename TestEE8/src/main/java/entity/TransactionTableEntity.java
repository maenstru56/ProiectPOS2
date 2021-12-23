package entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "TRANSACTION_TABLE", schema = "Database", catalog = "")
public class TransactionTableEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "TRANSACTION_DATE", nullable = true)
    private Timestamp transactionDate;
    @Basic
    @Column(name = "ID_CASHIER", nullable = false)
    private int idCashier;
    @Basic
    @Column(name = "ID_TYPE", nullable = false)
    private int idType;
    @Basic
    @Column(name = "VALUE", nullable = true, precision = 0)
    private Double value;
    @Basic
    @Column(name = "RENTAL_RETURN_DATE", nullable = true)
    private Timestamp rentalReturnDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getIdCashier() {
        return idCashier;
    }

    public void setIdCashier(int idCashier) {
        this.idCashier = idCashier;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Timestamp getRentalReturnDate() {
        return rentalReturnDate;
    }

    public void setRentalReturnDate(Timestamp rentalReturnDate) {
        this.rentalReturnDate = rentalReturnDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionTableEntity that = (TransactionTableEntity) o;
        return id == that.id && idCashier == that.idCashier && idType == that.idType && Objects.equals(transactionDate, that.transactionDate) && Objects.equals(value, that.value) && Objects.equals(rentalReturnDate, that.rentalReturnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, transactionDate, idCashier, idType, value, rentalReturnDate);
    }
}


package com.example.leichen.billanywhere.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.NotNull;

@Entity(nameInDb = "items")
public class Item {

    @Expose
    @SerializedName("id")
    @Id
    private Long id;

    @SerializedName("item_name")
    @Expose
    @Property(nameInDb = "item_name")
    private String itemName;

    @SerializedName("quantity")
    @Expose
    @Property(nameInDb = "quantity")
    private Integer quantity;

    @SerializedName("rate")
    @Expose
    @Property(nameInDb = "rate")
    private Integer rate;

    @SerializedName("amount")
    @Expose
    @Property(nameInDb = "amount")
    private Integer amount;

    @SerializedName("kind")
    @Expose
    @Property(nameInDb = "kind")
    private String kind;

    @ToOne(joinProperty = "billId")
    private Bill bill;

    private long billId;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 182764869)
    private transient ItemDao myDao;

    @Generated(hash = 1276473913)
    private transient Long bill__resolvedKey;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Item() {
    }



    @Generated(hash = 290751382)
    public Item(Long id, String itemName, Integer quantity, Integer rate,
            Integer amount, String kind, long billId) {
        this.id = id;
        this.itemName = itemName;
        this.quantity = quantity;
        this.rate = rate;
        this.amount = amount;
        this.kind = kind;
        this.billId = billId;
    }



    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }



    public Long getId() {
        return this.id;
    }



    public void setId(Long id) {
        this.id = id;
    }



    public long getBillId() {
        return this.billId;
    }



    public void setBillId(long billId) {
        this.billId = billId;
    }



    /** To-one relationship, resolved on first access. */
    @Generated(hash = 993835375)
    public Bill getBill() {
        long __key = this.billId;
        if (bill__resolvedKey == null || !bill__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BillDao targetDao = daoSession.getBillDao();
            Bill billNew = targetDao.load(__key);
            synchronized (this) {
                bill = billNew;
                bill__resolvedKey = __key;
            }
        }
        return bill;
    }



    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 601743104)
    public void setBill(@NotNull Bill bill) {
        if (bill == null) {
            throw new DaoException(
                    "To-one property 'billId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.bill = bill;
            billId = bill.getId();
            bill__resolvedKey = billId;
        }
    }



    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }



    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }



    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }



    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 881068859)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getItemDao() : null;
    }

}

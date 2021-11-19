package com.ds.watchtable.entity;

import javax.persistence.*;

public class PosTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PosTableNum;

    private Long TableNum;

    private Boolean checkOrder;

    @JoinColumn(name="storeNum")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Store store;






}

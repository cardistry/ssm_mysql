package com.bjpowernode.service.impl;

import com.bjpowernode.dao.GoodsDao;
import com.bjpowernode.dao.SaleDao;
import com.bjpowernode.domain.Goods;
import com.bjpowernode.domain.Sale;
import com.bjpowernode.exception.NorEnoughException;
import com.bjpowernode.service.BuyGoodsService;

public class BuyGoodsServiceImpl implements BuyGoodsService {


    private SaleDao saleDao;
    private GoodsDao goodsDao;
/*    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            readOnly = false,
            rollbackFor = {NullPointerException.class ,NorEnoughException.class}
    )*/
//    也可直接
//    @Transactional
    @Override
    public void buy(Integer goodsId, Integer nums) {
        //记录销售信息，向sale 表中添加记录
        System.out.println("buy 方法开始 =========");
        Sale sale = new Sale();
        sale.setGid(goodsId);
        sale.setNums(nums);
        saleDao.insertSale(sale);

        //更新库存
        Goods goods = goodsDao.selectGoods(goodsId);
        if(goods == null){
            //商品不存在
            throw new NullPointerException("编号是" + goodsId + ",商品不存在");
        } else if(goods.getAmount() < nums){
            throw new NorEnoughException("编号是" + goodsId + ",商品库存不足");
        }
        //修改库存
        Goods buyGoods = new Goods();
        buyGoods.setId(goodsId);
        buyGoods.setAmount(nums);
        goodsDao.updateGoods(buyGoods);
        System.out.println("buy 方法完成 =========");

    }

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }
}

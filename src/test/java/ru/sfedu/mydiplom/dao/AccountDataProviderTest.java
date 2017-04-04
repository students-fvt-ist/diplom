package ru.sfedu.mydiplom.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import ru.sfedu.mydiplom.model.dto.joinedtable.*;
import ru.sfedu.mydiplom.model.dto.mappedsuperclass.*;
import ru.sfedu.mydiplom.model.dto.singletable.*;
import ru.sfedu.mydiplom.model.dto.tableperclass.*;
import static ru.sfedu.mydiplom.utils.IDGenerator.getIDGenerator;

/**
 *
 * @author seyran
 */
public class AccountDataProviderTest {
    
    @Test
    public void testSaveOrUpdate() {
        System.out.println("saveOrUpdate");
        Optional<List> instanceAccJ = getJoinTAcc(10);
        Optional<List> instanceDebJ = getJoinTDebitAcc(10);
        Optional<List> instanceCreJ = getJoinTCreditAcc(10);
        Optional<List> instanceCreMS = getMappedSCCreditAcc(10);
        Optional<List> instanceDebMS = getMappedSCDebitAcc(10);
        Optional<List> instanceAccS = getSingleAcc(10);
        Optional<List> instanceDebS = getSingleDebitAcc(10);
        Optional<List> instanceCreS = getSingleCreditAcc(10);
        Optional<List> instanceAccTPC = getTPCAcc(10);
        Optional<List> instanceDebTPC = getTPCDebitAcc(10);
        Optional<List> instanceCreTPC = getTPCCreditAcc(10);
        AccountDataProvider instance = new AccountDataProvider();
        instance.saveOrUpdate(instanceAccJ);
        instance.saveOrUpdate(instanceDebJ);
        instance.saveOrUpdate(instanceCreJ);
        instance.saveOrUpdate(instanceCreMS);
        instance.saveOrUpdate(instanceDebMS);
        instance.saveOrUpdate(instanceAccS);
        instance.saveOrUpdate(instanceDebS);
        instance.saveOrUpdate(instanceCreS);
        instance.saveOrUpdate(instanceAccTPC);
        instance.saveOrUpdate(instanceDebTPC);
        instance.saveOrUpdate(instanceCreTPC);
    }

    @Test
    public void testGet() {
        System.out.println("get");
        AccountDataProvider instance = new AccountDataProvider();
        System.out.println(instance.get(1491263729831l, AccountJoinedTable.class).get());
        System.out.println(instance.get(1491263729871l, DebitAccountJoinedTable.class).get());
        System.out.println(instance.get(1491263793382l, CreditAccountJoinedTable.class).get());
        System.out.println(instance.get(1491263793390l, CreditAccountMappedSuperclass.class).get());
        System.out.println(instance.get(1491263729902l, DebitAccountMappedSuperclass.class).get());
        System.out.println(instance.get(1491263889914l, AccountSingleTable.class).get());
        System.out.println(instance.get(1491263889929l, DebitAccountSingleTable.class).get());
        System.out.println(instance.get(1491263889943l, CreditAccountSingleTable.class).get());
        System.out.println(instance.get(1491264245008l, AccountTablePerClass.class).get());
        System.out.println(instance.get(1491264245021l, DebitAccountTablePerClass.class).get());
        System.out.println(instance.get(1491264245034l, CreditAccountTablePerClass.class).get());
    }

    @Test
    public void testDeleteMulti() {
        System.out.println("deleteMulti");
        Optional<List> instanceAccJ = getJoinTAcc(10);
        Optional<List> instanceDebJ = getJoinTDebitAcc(10);
        Optional<List> instanceCreJ = getJoinTCreditAcc(10);
        Optional<List> instanceCreMS = getMappedSCCreditAcc(10);
        Optional<List> instanceDebMS = getMappedSCDebitAcc(10);
        Optional<List> instanceAccS = getSingleAcc(10);
        Optional<List> instanceDebS = getSingleDebitAcc(10);
        Optional<List> instanceCreS = getSingleCreditAcc(10);
        Optional<List> instanceAccTPC = getTPCAcc(10);
        Optional<List> instanceDebTPC = getTPCDebitAcc(10);
        Optional<List> instanceCreTPC = getTPCCreditAcc(10);
        AccountDataProvider instance = new AccountDataProvider();
        instance.saveOrUpdate(instanceAccJ);
        instance.saveOrUpdate(instanceDebJ);
        instance.saveOrUpdate(instanceCreJ);
        instance.saveOrUpdate(instanceCreMS);
        instance.saveOrUpdate(instanceDebMS);
        instance.saveOrUpdate(instanceAccS);
        instance.saveOrUpdate(instanceDebS);
        instance.saveOrUpdate(instanceCreS);
        instance.saveOrUpdate(instanceAccTPC);
        instance.saveOrUpdate(instanceDebTPC);
        instance.saveOrUpdate(instanceCreTPC);
        
        instance.deleteMulti(instanceAccJ);
        instance.deleteMulti(instanceDebJ);
        instance.deleteMulti(instanceCreJ);
        instance.deleteMulti(instanceCreMS);
        instance.deleteMulti(instanceDebMS);
        instance.deleteMulti(instanceAccS);
        instance.deleteMulti(instanceDebS);
        instance.deleteMulti(instanceCreS);
        instance.deleteMulti(instanceAccTPC);
        instance.deleteMulti(instanceDebTPC);
        instance.deleteMulti(instanceCreTPC);
    }
    
    private Optional<List> getJoinTAcc(int count){
        Optional<List> optional;
        List<AccountJoinedTable> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(new AccountJoinedTable(getIDGenerator().getID(), BigDecimal.ONE, "owner"+i, BigDecimal.ZERO));
        }
        optional = Optional.ofNullable(list);
        return optional;
    }
    
    private Optional<List> getJoinTDebitAcc(int count){
        Optional<List> optional;
        List<DebitAccountJoinedTable> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(new DebitAccountJoinedTable(BigDecimal.ZERO, getIDGenerator().getID(), BigDecimal.ONE, "owner"+i, BigDecimal.ZERO));
        }
        optional = Optional.ofNullable(list);
        return optional;
    }
    
    private Optional<List> getJoinTCreditAcc(int count){
        Optional<List> optional;
        List<AccountJoinedTable> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(new CreditAccountJoinedTable(BigDecimal.ZERO, getIDGenerator().getID(), BigDecimal.ONE, "owner"+i, BigDecimal.ZERO));
        }
        optional = Optional.ofNullable(list);
        return optional;
    }
    
    private Optional<List> getMappedSCDebitAcc(int count){
        Optional<List> optional;
        List<DebitAccountMappedSuperclass> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(new DebitAccountMappedSuperclass(BigDecimal.ZERO, getIDGenerator().getID(), BigDecimal.ONE, "owner"+i, BigDecimal.ZERO));
        }
        optional = Optional.ofNullable(list);
        return optional;
    }
    
    private Optional<List> getMappedSCCreditAcc(int count){
        Optional<List> optional;
        List<CreditAccountMappedSuperclass> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(new CreditAccountMappedSuperclass(BigDecimal.ZERO, getIDGenerator().getID(), BigDecimal.ONE, "owner"+i, BigDecimal.ZERO));
        }
        optional = Optional.ofNullable(list);
        return optional;
    }
    
    
    private Optional<List> getSingleAcc(int count){
        Optional<List> optional;
        List<AccountSingleTable> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(new AccountSingleTable(getIDGenerator().getID(), BigDecimal.ONE, "owner"+i, BigDecimal.ZERO));
        }
        optional = Optional.ofNullable(list);
        return optional;
    }
    
    private Optional<List> getSingleDebitAcc(int count){
        Optional<List> optional;
        List<DebitAccountSingleTable> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(new DebitAccountSingleTable(BigDecimal.ZERO, getIDGenerator().getID(), BigDecimal.ONE, "owner"+i, BigDecimal.ZERO));
        }
        optional = Optional.ofNullable(list);
        return optional;
    }
    
    private Optional<List> getSingleCreditAcc(int count){
        Optional<List> optional;
        List<CreditAccountSingleTable> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(new CreditAccountSingleTable(BigDecimal.ZERO, getIDGenerator().getID(), BigDecimal.ONE, "owner"+i, BigDecimal.ZERO));
        }
        optional = Optional.ofNullable(list);
        return optional;
    }
    
    private Optional<List> getTPCAcc(int count){
        Optional<List> optional;
        List<AccountTablePerClass> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(new AccountTablePerClass(getIDGenerator().getID(), BigDecimal.ONE, "owner"+i, BigDecimal.ZERO));
        }
        optional = Optional.ofNullable(list);
        return optional;
    }
    
    private Optional<List> getTPCDebitAcc(int count){
        Optional<List> optional;
        List<DebitAccountTablePerClass> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(new DebitAccountTablePerClass(BigDecimal.ZERO, getIDGenerator().getID(), BigDecimal.ONE, "owner"+i, BigDecimal.ZERO));
        }
        optional = Optional.ofNullable(list);
        return optional;
    }
    
    private Optional<List> getTPCCreditAcc(int count){
        Optional<List> optional;
        List<CreditAccountTablePerClass> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(new CreditAccountTablePerClass(BigDecimal.ZERO, getIDGenerator().getID(), BigDecimal.ONE, "owner"+i, BigDecimal.ZERO));
        }
        optional = Optional.ofNullable(list);
        return optional;
    }
}


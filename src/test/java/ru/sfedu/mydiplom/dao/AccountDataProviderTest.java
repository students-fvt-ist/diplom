package ru.sfedu.mydiplom.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import ru.sfedu.mydiplom.model.dto.joinedtable.AccountJoinedTable;
import ru.sfedu.mydiplom.model.dto.joinedtable.CreditAccountJoinedTable;
import ru.sfedu.mydiplom.model.dto.joinedtable.DebitAccountJoinedTable;
import ru.sfedu.mydiplom.model.dto.mappedsuperclass.CreditAccountMappedSuperclass;
import ru.sfedu.mydiplom.model.dto.mappedsuperclass.DebitAccountMappedSuperclass;
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
        AccountDataProvider instance = new AccountDataProvider();
        instance.saveOrUpdate(instanceAccJ);
        instance.saveOrUpdate(instanceDebJ);
        instance.saveOrUpdate(instanceCreJ);
        instance.saveOrUpdate(instanceCreMS);
        instance.saveOrUpdate(instanceDebMS);
    }

    @Test
    public void testGet() {
        System.out.println("get");
        long id = 0L;
        Class clazz = null;
        AccountDataProvider instance = new AccountDataProvider();
        Optional expResult = null;
        Optional result = instance.get(id, clazz);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testDelete() {
        System.out.println("delete");
        Optional instance_2 = null;
        AccountDataProvider instance = new AccountDataProvider();
        instance.delete(instance_2);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testDeleteMulti() {
        System.out.println("deleteMulti");
        Optional<List> instance_2 = null;
        AccountDataProvider instance = new AccountDataProvider();
        instance.deleteMulti(instance_2);
        // TODO review the generated test code and remove the default call to fail.
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
        List<AccountJoinedTable> list = new ArrayList<>();
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
}


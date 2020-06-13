package database.app_database.Dao;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.ComparableExpressionBase;
import database.app_database.Model.Feed.QSupply;
import database.app_database.Model.Feed.Supply;
import org.springframework.stereotype.Repository;

import static database.app_database.Model.Feed.QSupply.supply;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SupplyDao extends BaseEntityDao<Supply, QSupply> {

    public SupplyDao() {
        super(supply);
    }

    public List<Supply> getAll() {
        return from(supply)
                .select(supply)
                .fetch();
    }

    public List<Supply> getZooSupplies() {
        return from(supply)
                .where(supply.provider.name.eq("Зоопарк"))
                .select(supply)
                .fetch();
    }

    public List<Supply> getByBasicInfo(String feedName, Integer lowAmount, Integer highAmount,
                                       Instant highDate, Instant lowDate, Integer lowPrice, Integer highPrice,
                                       String feedNamePart, String providerNamePart,
                                       String sortingAttribute, String sortingType, Integer page) {

        var predicate = createPredicate(feedName, lowAmount, highAmount,
                highDate, lowDate, lowPrice, highPrice,
                feedNamePart, providerNamePart);

        return from(supply)
                .where(predicate.getValue())
                .orderBy(getOrderSpecifier(sortingAttribute, sortingType))
                .limit(10)
                .offset((page - 1) * 10)
                .select(supply, supply.provider, supply.feed)
                .fetch()
                .stream()
                .map(tuple -> tuple.get(supply))
                .collect(Collectors.toList());
    }

    public List<Supply> getSuppliesForQuery(String feedName, Integer lowAmount, Integer highAmount,
                                            Instant highDate, Instant lowDate, Integer lowPrice, Integer highPrice,
                                            String feedNamePart, String providerNamePart,
                                            String sortingAttribute, String sortingType) {

        var predicate = createPredicate(feedName, lowAmount, highAmount,
                highDate, lowDate, lowPrice, highPrice,
                feedNamePart, providerNamePart);

        return from(supply)
                .where(predicate.getValue())
                .orderBy(getOrderSpecifier(sortingAttribute, sortingType))
                .select(supply, supply.provider, supply.feed)
                .fetch()
                .stream()
                .map(tuple -> tuple.get(supply))
                .collect(Collectors.toList());
    }

    private BooleanBuilder createPredicate(String feedName, Integer lowAmount, Integer highAmount,
                                           Instant highDate, Instant lowDate, Integer lowPrice, Integer highPrice,
                                           String feedNamePart, String providerNamePart) {

        var predicate = new BooleanBuilder();
        if (feedName != null) {
            predicate.and(supply.feed.name.eq(feedName));
        }

        if (feedNamePart != null) {
            predicate.and(supply.feed.name.contains(feedNamePart));
        }

        if (providerNamePart != null) {
            predicate.and(supply.provider.name.contains(providerNamePart));
        }

        if (lowAmount != null) {
            predicate.and(supply.feedAmount.goe(lowAmount));
        }

        if (highAmount != null) {
            predicate.and(supply.feedAmount.loe(highAmount));
        }

        if (lowDate != null) {
            predicate.and(supply.supplyDate.after(lowDate));
        }

        if (highDate != null) {
            predicate.and(supply.supplyDate.before(highDate));
        }

        if (lowPrice != null) {
            predicate.and(supply.price.goe(lowPrice));
        }

        if (highPrice != null) {
            predicate.and(supply.price.loe(highPrice));
        }

        return predicate;
    }

    private OrderSpecifier getOrderSpecifier(String sortingAttribute, String sortingType) {
        if (sortingAttribute == null) {
            return supply.id.asc();
        }

        ComparableExpressionBase field = getComparableExpressionBase(sortingAttribute);

        var asc = true;

        if (sortingType.equals("desc")) {
            asc = false;
        }

        return asc ? field.asc() : field.desc();
    }

    private ComparableExpressionBase getComparableExpressionBase(String sortingAttribute) {
        ComparableExpressionBase field = null;

        if (sortingAttribute.equals("providerName")) {
            field = supply.provider.name;
        }

        if (sortingAttribute.equals("feedName")) {
            field = supply.feed.name;
        }

        if (sortingAttribute.equals("price")) {
            field = supply.price;
        }

        if (sortingAttribute.equals("supplyDate")) {
            field = supply.supplyDate;
        }

        if (sortingAttribute.equals("feedAmount")) {
            field = supply.feedAmount;
        }

        if (field == null) {
            throw new IllegalArgumentException("Wrong sorting attribute");
        }

        return field;
    }
}

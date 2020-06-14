package database.app_database.Dao;

import com.mysema.commons.lang.CloseableIterator;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public abstract class BaseEntityDao<T, Q extends EntityPathBase<T>> {

    @PersistenceContext
    protected EntityManager em;

    protected Q qClass;

    public BaseEntityDao(Q qClass) {
        this.qClass = qClass;
    }

    protected EntityManager getEntityManager() {
        return em;
    }

    protected <P> JPAQuery<P> from(final EntityPath<?>... entityPaths) {
        return new BaseJPAQuery<P>(em).from(entityPaths).distinct();
    }

    protected Optional<T> find(final JPAQuery<?> query) {
        T result = query.select(qClass).fetchOne();
        return Optional.ofNullable(result);
    }

    protected Optional<T> findAny(final JPAQuery<?> query) {
        T result = query.select(qClass).fetchFirst();
        return Optional.ofNullable(result);
    }

    public List<T> getAll() {
        return from(qClass).select(qClass).fetch();
    }

    public void cleanup() {
        EntityManager em = getEntityManager();
        from(qClass).select(qClass).fetch().forEach(em::remove);
    }

    protected long getCount(final JPAQuery<?> query, Expression<Long> t) {
        Long resultCount = query.select(t).fetchOne();
        if (resultCount == null) {
            throw new RuntimeException("Count query failed");
        }
        return resultCount;
    }

    protected Predicate inIds(final NumberPath<Long> idPath, final Collection<Long> entityIds) {
        if (entityIds.isEmpty()) {
            return Expressions.booleanTemplate("1 = 2");
        }

        BooleanBuilder builder = new BooleanBuilder();
        entityIds.forEach(id -> builder.or(idPath.eq(id)));
        return builder.getValue();
    }

    public <K extends T> K persist(final K entity) {
        getEntityManager().persist(entity);
        getEntityManager().flush();
        return entity;
    }

    protected void delete(final JPAQuery<T> query) {
        delete(query, entity -> getEntityManager().remove(entity));
    }

    protected void delete(final JPAQuery<T> query, final Consumer<T> remove) {
        try (CloseableIterator<T> iterator = query.iterate()) {
            while (iterator.hasNext()) {
                remove.accept(iterator.next());
            }
        }

        flush();
    }

    public void delete(final T entity) {
        getEntityManager().remove(entity);
        getEntityManager().flush();
    }

    public void flush() {
        getEntityManager().flush();
    }

    public void refresh(final Object o) {
        getEntityManager().refresh(o);
    }

    public void resetCache() {
        getEntityManager().getEntityManagerFactory().getCache().evictAll();
    }
}
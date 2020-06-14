create function check_date_of_birth() returns trigger as $check_trigger$
    BEGIN

        if new.date_of_birth > new.reciept_date then
            raise exception 'receipt date can not be less than date of birth';
        end if;

        return new;

    END
$check_trigger$ LANGUAGE plpgsql;

create trigger check_trigger before insert or update on animal
    for each row execute procedure check_date_of_birth();
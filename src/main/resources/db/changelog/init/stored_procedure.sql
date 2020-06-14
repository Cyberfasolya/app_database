create function get_number_of_zoo_supplies()
returns bigint
as $$

select COUNT(*) from(
    select supply.id
    from provider inner join supply
    on provider.id = supply.provider_id
    and provider.name = 'Зоопарк'
) as counter

$$
language sql



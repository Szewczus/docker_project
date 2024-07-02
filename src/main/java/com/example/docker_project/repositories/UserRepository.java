package com.example.docker_project.repositories;

import com.example.docker_project.dtos.KafkaUserHolidayReportDto;
import com.example.docker_project.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Boolean existsUserEntitiesByLogin(String login);
    UserEntity findUserEntityByLogin(String login);
    UserEntity findUserEntityById(Long id);

    @Query(value = "select he.travel_destination as travelDestination, he.destination_address as destinationAddress, tppe.description, he.arrive_date as arriveDate, he.departure_date as departureDate, he.accomodation_cost as accomodationCost from user_entity u inner join public.holiday_entity he on u.id = he.user_id " +
            "inner join public.trip_plan_point_entity tppe on he.id = tppe.holiday_id where login=:login", nativeQuery = true)
    List<KafkaUserHolidayReportDto> getReportByLogin(@Param("login") String login);
}

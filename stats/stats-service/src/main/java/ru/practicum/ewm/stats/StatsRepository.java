package ru.practicum.ewm.stats;

import org.springframework.data.jpa.repository.JpaRepository;

interface StatsRepository extends JpaRepository<EndpointHit, Long> {

}

package co.istad.mobilebankingcstad.features.user.dto;


import lombok.Builder;

@Builder
public record UserRequest (String name,String gender) {
}

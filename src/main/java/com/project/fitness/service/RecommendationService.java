package com.project.fitness.service;

import com.project.fitness.dto.RecommendationRequest;
import com.project.fitness.model.Activity;
import com.project.fitness.model.Recommendation;
import com.project.fitness.model.User;
import com.project.fitness.repository.ActivityRepository;
import com.project.fitness.repository.RecommendationRepository;
import com.project.fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;
    private final RecommendationRepository recommendationRepository;

    // GENERATE RECOMMENDATION
    public Recommendation generateRecommendation(RecommendationRequest request) {

        // FIND USER
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "User Not Found: " + request.getUserId()
                        )
                );

        // FIND ACTIVITY
        Activity activity = activityRepository.findById(request.getActivityId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Activity Not Found: " + request.getActivityId()
                        )
                );

        // GENERATE DYNAMIC RECOMMENDATION MESSAGE
        String recommendationMessage = generateRecommendationMessage(activity);

        // CREATE RECOMMENDATION OBJECT
        Recommendation recommendation = Recommendation.builder()
                .user(user)
                .activity(activity)

                // IMPORTANT FIX
                .type(activity.getType().name())
                .recommendation(recommendationMessage)

                .improvements(request.getImprovements())
                .suggestions(request.getSuggestions())
                .safety(request.getSafety())
                .build();

        // SAVE INTO DATABASE
        return recommendationRepository.save(recommendation);
    }

    // GET USER RECOMMENDATIONS
    public List<Recommendation> getUserRecommendation(String userId) {
        return recommendationRepository.findByUserId(userId);
    }

    // GET ACTIVITY RECOMMENDATIONS
    public List<Recommendation> getActivityRecommendation(String activityId) {
        return recommendationRepository.findByActivityId(activityId);
    }

    // DYNAMIC RECOMMENDATION LOGIC
    private String generateRecommendationMessage(Activity activity) {

        switch (activity.getType()) {

            case RUNNING:
                return "Increase running duration gradually and maintain hydration.";

            case CYCLING:
                return "Maintain consistent cycling speed and improve endurance.";

            case YOGA:
                return "Focus on breathing techniques and flexibility improvement.";

            case SWIMMING:
                return "Improve swimming posture and increase lap count gradually.";

            case WEIGHT_TRAINING:
                return "Increase weights progressively while maintaining form.";

            case HIIT:
                return "Take proper rest intervals and avoid overtraining.";

            default:
                return "Maintain regular physical activity for better fitness.";
        }
    }
}
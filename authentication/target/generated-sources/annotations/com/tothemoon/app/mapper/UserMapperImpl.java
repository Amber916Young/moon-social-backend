package com.tothemoon.app.mapper;

import com.tothemoon.app.dto.BasicUserInfoDTO;
import com.tothemoon.app.dto.UserDTO;
import com.tothemoon.common.entity.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-22T10:25:22+0000",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_352 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );
        userDTO.setUsername( user.getUsername() );
        userDTO.setNickname( user.getNickname() );
        userDTO.setEmail( user.getEmail() );
        userDTO.setIsEmailConfirmed( user.getIsEmailConfirmed() );
        userDTO.setPassword( user.getPassword() );
        userDTO.setAvatarUrl( user.getAvatarUrl() );
        byte[] preferences = user.getPreferences();
        if ( preferences != null ) {
            userDTO.setPreferences( Arrays.copyOf( preferences, preferences.length ) );
        }
        userDTO.setJoinedAt( user.getJoinedAt() );
        userDTO.setLastSeenAt( user.getLastSeenAt() );
        userDTO.setMarkedAllAsReadAt( user.getMarkedAllAsReadAt() );
        userDTO.setReadNotificationsAt( user.getReadNotificationsAt() );
        userDTO.setDiscussionCount( user.getDiscussionCount() );
        userDTO.setCommentCount( user.getCommentCount() );
        userDTO.setReadFlagsAt( user.getReadFlagsAt() );
        userDTO.setSuspendedUntil( user.getSuspendedUntil() );
        userDTO.setSuspendReason( user.getSuspendReason() );
        userDTO.setSuspendMessage( user.getSuspendMessage() );
        userDTO.setInviteCode( user.getInviteCode() );
        userDTO.setTotalCheckinCount( user.getTotalCheckinCount() );
        userDTO.setTotalContinuousCheckinCount( user.getTotalContinuousCheckinCount() );
        userDTO.setLastCheckinTime( user.getLastCheckinTime() );
        userDTO.setPronouns( user.getPronouns() );
        userDTO.setBlocksByobuPd( user.getBlocksByobuPd() );
        userDTO.setVotes( user.getVotes() );
        userDTO.setRank( user.getRank() );
        userDTO.setLastVoteTime( user.getLastVoteTime() );
        userDTO.setNewAchievements( user.getNewAchievements() );
        userDTO.setCarvingContestEntryCount( user.getCarvingContestEntryCount() );
        userDTO.setMoney( user.getMoney() );
        userDTO.setSocialButtons( user.getSocialButtons() );
        userDTO.setBio( user.getBio() );
        userDTO.setSignature( user.getSignature() );
        userDTO.setHasPwnedPassword( user.getHasPwnedPassword() );

        return userDTO;
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDTO.getId() );
        user.setUsername( userDTO.getUsername() );
        user.setNickname( userDTO.getNickname() );
        user.setEmail( userDTO.getEmail() );
        user.setIsEmailConfirmed( userDTO.getIsEmailConfirmed() );
        user.setPassword( userDTO.getPassword() );
        user.setAvatarUrl( userDTO.getAvatarUrl() );
        byte[] preferences = userDTO.getPreferences();
        if ( preferences != null ) {
            user.setPreferences( Arrays.copyOf( preferences, preferences.length ) );
        }
        user.setJoinedAt( userDTO.getJoinedAt() );
        user.setLastSeenAt( userDTO.getLastSeenAt() );
        user.setMarkedAllAsReadAt( userDTO.getMarkedAllAsReadAt() );
        user.setReadNotificationsAt( userDTO.getReadNotificationsAt() );
        user.setDiscussionCount( userDTO.getDiscussionCount() );
        user.setCommentCount( userDTO.getCommentCount() );
        user.setReadFlagsAt( userDTO.getReadFlagsAt() );
        user.setSuspendedUntil( userDTO.getSuspendedUntil() );
        user.setSuspendReason( userDTO.getSuspendReason() );
        user.setSuspendMessage( userDTO.getSuspendMessage() );
        user.setInviteCode( userDTO.getInviteCode() );
        user.setTotalCheckinCount( userDTO.getTotalCheckinCount() );
        user.setTotalContinuousCheckinCount( userDTO.getTotalContinuousCheckinCount() );
        user.setLastCheckinTime( userDTO.getLastCheckinTime() );
        user.setPronouns( userDTO.getPronouns() );
        user.setBlocksByobuPd( userDTO.getBlocksByobuPd() );
        user.setVotes( userDTO.getVotes() );
        user.setRank( userDTO.getRank() );
        user.setLastVoteTime( userDTO.getLastVoteTime() );
        user.setNewAchievements( userDTO.getNewAchievements() );
        user.setCarvingContestEntryCount( userDTO.getCarvingContestEntryCount() );
        user.setMoney( userDTO.getMoney() );
        user.setSocialButtons( userDTO.getSocialButtons() );
        user.setBio( userDTO.getBio() );
        user.setSignature( userDTO.getSignature() );
        user.setHasPwnedPassword( userDTO.getHasPwnedPassword() );

        return user;
    }

    @Override
    public List<UserDTO> toDTOList(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( users.size() );
        for ( User user : users ) {
            list.add( toDTO( user ) );
        }

        return list;
    }

    @Override
    public BasicUserInfoDTO toBasicUserInfoDTO(User user) {
        if ( user == null ) {
            return null;
        }

        BasicUserInfoDTO basicUserInfoDTO = new BasicUserInfoDTO();

        basicUserInfoDTO.setId( user.getId() );
        basicUserInfoDTO.setUsername( user.getUsername() );
        basicUserInfoDTO.setAvatarUrl( user.getAvatarUrl() );
        basicUserInfoDTO.setNickname( user.getNickname() );

        return basicUserInfoDTO;
    }
}

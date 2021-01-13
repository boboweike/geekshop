/*
 * Copyright (c) 2020 GeekShop.
 * All rights reserved.
 */

package io.geekshop.resolver.dataloader;

import io.geekshop.common.utils.BeanMapper;
import io.geekshop.entity.AdministratorEntity;
import io.geekshop.entity.UserEntity;
import io.geekshop.mapper.AdministratorEntityMapper;
import io.geekshop.mapper.UserEntityMapper;
import io.geekshop.types.user.User;
import org.dataloader.MappedBatchLoader;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

/**
 * Created on Nov, 2020 by @author bobo
 */
@SuppressWarnings("Duplicates")
public class AdministratorUserDataLoader implements MappedBatchLoader<Long, User> {
    private final UserEntityMapper userEntityMapper;
    private final AdministratorEntityMapper administratorEntityMapper;

    public AdministratorUserDataLoader(UserEntityMapper userEntityMapper,
                                       AdministratorEntityMapper administratorEntityMapper) {
        this.userEntityMapper = userEntityMapper;
        this.administratorEntityMapper = administratorEntityMapper;
    }

    @Override
    public CompletionStage<Map<Long, User>> load(Set<Long> administratorIds) {
        return CompletableFuture.supplyAsync(() -> {
            Map<Long, User> administratorUserMap = new HashMap<>();
            List<AdministratorEntity> administratorEntityList =
                    this.administratorEntityMapper.selectBatchIds(administratorIds);
            if (CollectionUtils.isEmpty(administratorEntityList)) return administratorUserMap;

            List<Long> userIdList = administratorEntityList.stream()
                    .map(AdministratorEntity::getUserId)
                    .collect(Collectors.toList());

            List<UserEntity> userEntityList = this.userEntityMapper.selectBatchIds(userIdList);
            if (CollectionUtils.isEmpty(userEntityList)) return administratorUserMap;

            Map<Long, UserEntity> userEntityMap = userEntityList.stream()
                    .collect(Collectors.toMap(UserEntity::getId, userEntity -> userEntity));

            administratorEntityList.forEach(administratorEntity -> {
                Long administratorId = administratorEntity.getId();
                Long userId = administratorEntity.getUserId();
                UserEntity userEntity = userEntityMap.get(userId);
                if (userEntity != null) {
                    User user = BeanMapper.map(userEntity, User.class);
                    administratorUserMap.put(administratorId, user);
                }
            });

            return administratorUserMap;
        });
    }
}

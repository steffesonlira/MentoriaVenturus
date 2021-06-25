/*
 * Copyright 2020 by Samsung Eletrônica da Amazônia Ltda. All rights reserved.
 *
 * This software and its code is the confidential ("Confidential Information")
 * and proprietary information of Samsung Eletrônica da Amzônia Ltda.
 * You shall not disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with Samsung Eletrônica da Amazônia Ltda.
 */

package com.example.mentoriaventurus.data.rest.mappers

import com.example.mentoriaventurus.data.rest.responses.ResultResponse
import com.example.mentoriaventurus.domain.models.Result

class ResultMapper {

    fun fromResponse(response: ResultResponse): Result = with(response) {
        Result(name = name, url = url)
    }
}
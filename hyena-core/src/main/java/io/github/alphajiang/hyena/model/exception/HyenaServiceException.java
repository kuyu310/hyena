/*
 *  Copyright (C) 2019 Alpha Jiang. All rights reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package io.github.alphajiang.hyena.model.exception;

import io.github.alphajiang.hyena.HyenaConstants;
import org.slf4j.event.Level;

public class HyenaServiceException extends BaseException {
    private static final int CODE = HyenaConstants.RES_CODE_SERVICE_ERROR;

    public HyenaServiceException(String msg, Level logLevel) {
        super(CODE, msg, logLevel);
    }


    public HyenaServiceException(String msg, Throwable e) {
        super(CODE, msg, e);
    }

    public HyenaServiceException(int code, String msg, Throwable e) {
        super(code, msg, e);
    }

    public HyenaServiceException(int code, String msg, Level logLevel) {
        super(code, msg, logLevel);

    }

    public HyenaServiceException(String msg) {
        super(CODE, msg);
    }


    public HyenaServiceException(int code, String msg) {
        super(code, msg);
    }
}

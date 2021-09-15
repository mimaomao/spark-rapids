/*
 * Copyright (c) 2021, NVIDIA CORPORATION.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nvidia.spark.rapids.shims.spark320

import com.nvidia.spark.rapids.{SparkShims, SparkShimVersion}

object SparkShimServiceProvider {
  // temporarily allow 3.2.1 while 3.2.0 release candidates are being produced
  val VERSION320 = SparkShimVersion(3, 2, 0)
  val VERSION321 = SparkShimVersion(3, 2, 1)
  val VERSIONNAMES: Seq[String] = Seq(VERSION320, VERSION321)
    .flatMap(v => Seq(s"$v", s"$v-SNAPSHOT"))
}

class SparkShimServiceProvider extends com.nvidia.spark.rapids.SparkShimServiceProvider {

  def matchesVersion(version: String): Boolean = {
    SparkShimServiceProvider.VERSIONNAMES.contains(version)
  }

  def buildShim: SparkShims = {
    new Spark320Shims()
  }
}

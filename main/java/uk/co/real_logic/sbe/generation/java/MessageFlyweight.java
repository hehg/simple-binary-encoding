/*
 * Copyright 2013 Real Logic Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.co.real_logic.sbe.generation.java;

/**
 * Interface for locating a variable length flyweight over a {@link DirectBuffer}.
 */
public interface MessageFlyweight
{
    /**
     * Get the root block length for the message type.
     *
     * @return the root block length for the message type.
     */
    int blockLength();

    /**
     * Get the identifier fo the template for this codec.
     *
     * @return the identifier fo the template for this codec.
     */
    long templateId();

    /**
     * Get the version up to which this template supports.
     *
     * @return the version up to which this template supports.
     */
    int templateVersion();

    /**
     * Offset in the underlying buffer at which the message starts.
     *
     * @return offset in the underlying buffer at which the message starts.
     */
    int offset();

    /**
     * Reset the flyweight to a new index in a buffer to overlay a message for encoding.
     *
     * @param buffer underlying the message.
     * @param offset at which the message body begins.
     * @return the flyweight as a sub classed covariant type to provide a fluent API.
     */
    MessageFlyweight resetForEncode(final DirectBuffer buffer, final int offset);

    /**
     * Reset the flyweight to a new index in a buffer to overlay a message for decoding.
     *
     * @param buffer underlying the message.
     * @param offset at which the message body begins.
     * @param actingBlockLength to be used when decoding the message.
     * @param actingVersion of the template to be used with decoding the message.
     * @return the flyweight as a sub classed covariant type to provide a fluent API.
     */
    MessageFlyweight resetForDecode(final DirectBuffer buffer, final int offset,
                                    final int actingBlockLength, final int actingVersion);

    /**
     * The position for the first byte of the next block in the buffer.
     *
     * @param position for the first byte of the next block in the buffer.
     */
    void position(final int position);

    /**
     * The position for the first byte of the next block in the buffer.
     *
     * @return the position for the first byte of the next block in the buffer.
     */
    int position();
}

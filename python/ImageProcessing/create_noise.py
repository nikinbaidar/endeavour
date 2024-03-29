# !/usr/bin/env python
#
#  /"\/\_..---------------------------------------------------._/\/"\
# (     _|| Filename    : create_noise.py                    ||_     )
#  \_/\/ || Maitaner    : Nikin Baidar                       || \/\_/
#        || Description : Add different type of noise to     ||
#        ||               image data.                        ||
#        ||                                                  ||
#  /"\/\_|----------------------------------------------------|_/\/"\
# (     _|                                                    |_     )
#  \_/\/ `----------------------------------------------------' \/\_/

import cv2
import numpy
from matplotlib import pyplot

from convolution import pause

def plotHistogram(processed_image, plotTitle="", bins=256):
    pyplot.hist(processed_image.ravel(), label="Processed", bins=bins)
    pyplot.xlabel("Pixel Intensities")
    pyplot.ylabel("Frequency")
    pyplot.title(plotTitle)
    pyplot.legend()
    pyplot.show()


def addSpeckleNoise(image, scale):
    '''
    Speckle noise is multiplicitive noise, having a granular pattern. Inherent
    in ultrasound images. The small part of the returning sound pulse gets
    mirrored back into the tissues by the transducer surface itself, and
    generates a new echo. The backscattered echoes give rise to speckle noise.

    Reference for spekcle modelling: https://bit.ly/3umKfZS
    '''
    noise = numpy.random.rayleigh(scale, image.shape)
    noisy_image = image * noise
    return noisy_image


def addSpeckleNoise2(image, MEAN, VARIANCE):
    noise = numpy.random.normal(MEAN, VARIANCE, image.shape)
    noisy_image = image * (1 + noise)
    return noisy_image


def addGaussianNoise(image, MEAN, VARIANCE):
    noise = numpy.random.normal(MEAN, VARIANCE, image.shape)
    noisy_image = image + noise
    return noisy_image


def main():

    image = cv2.imread("./images/ultrasound-fetus.duckduckgo.com.jpg", \
        cv2.IMREAD_GRAYSCALE) / 255.0

    # Display images

    ##################
    # Gaussian Noise #
    ##################

    # gaussian_noisy_img = addGaussianNoise(image, 0.2, 0.9)
    # cv2.imshow("Gaussian Noisy Image", gaussian_noisy_img)

    #################
    # Speckle Noise #
    #################

    # speckle_noisy_img = addSpeckleNoise(image, 0.2)
    # speckle_noisy_img2 = addSpeckleNoise2(image, 0.2, 0.9)
    # cv2.imshow("Speckle Noisy Image", speckle_noisy_img)
    # cv2.imshow("Speckle Noisy Image using Gaussian Noise", speckle_noisy_img2)

    cv2.imshow("Original Image", image)
    pause()

    ###################
    # Histogram plots #
    ###################

    # plotHistogram(processed_image=gaussian_noisy_img)
    # pyplot.show()


if __name__ == '__main__':
    main()
